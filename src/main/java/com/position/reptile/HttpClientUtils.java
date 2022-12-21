package com.position.reptile;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpClientUtils {
    // 编码格式，发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";
    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 6000;
    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * Description: 封装请求头
     *
     * @param params
     * @param httpMethod
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            //通过entrySet()方法从params中返回所有键值对的集合，并保存在entrySet中，然后通过foreach方法每次取出一个键值对保存在一个entry中
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                // 通过entry获取分别获取键-值，将键-值参数设置到请求头HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException
     */
    public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod) throws UnsupportedEncodingException {
        // 封装请求参数
        if (params != null) {
            /**
             * NameValuePair是简单名称值对节点类型。
             * 多用于Java像url发送Post请求。在发送
             * post请求时用该list来存放参数。
             */
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            /**
             * 通过entrySet()方法从params中返回所有键值对的集合，
             * 并保存在entrySet中，然后通过foreach方法每次取出一
             * 个键值对保存在一个entry中。
             */
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                //分别提取entry中的key和value放入nvps数组中。
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            // 设置到请求的http对象中，这里的ENCODING为之前创建的编码常量。
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * Description: 获得响应结果
     *
     * @param httpResponse
     * @param httpClient
     * @param httpMethod
     * @return
     * @throws Exception
     */
    public static HttpClientResp getHttpClientResult(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws Exception {
        // 通过请求参数httpMethod执行HTTP请求
        httpResponse = httpClient.execute(httpMethod);
        // 获取HTTP的响应结果
        if (httpResponse != null && httpResponse.getStatusLine() != null) {
            String content = "";
            if (httpResponse.getEntity() != null) {
                //将响应结果转为String类型，并设置编码格式
                content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
            }
            /**
             * 返回HttpClientResp实体类的对象，这两个参数分
             * 别代表实体类中的code属性和content属性，分别代
             * 表响应代码和响应内容。
             */
            return new HttpClientResp(httpResponse.getStatusLine().getStatusCode(), content);
        }
        //如果没有接收到响应内容则返回响应的错误信息
        return new HttpClientResp(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }


    /**
     * 发送Post请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResp doPost(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建http post对象
        HttpPost httpPost = new HttpPost(url);
        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)
         * 获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果
         * 访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        //封装请求配置项
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        //设置post请求配置项
        httpPost.setConfig(requestConfig);
        //通过创建的packageHeader方法设置请求头
        packageHeader(headers, httpPost);
        //通过创建的packageParam方法设置请求参数
        packageParam(params, httpPost);
        //创建httpResponse对象获取响应内容
        CloseableHttpResponse httpResponse = null;
        try {
            //执行请求并获得响应结果
            return getHttpClientResult(httpResponse, httpClient, httpPost);
        } finally {
            // 释放资源
            release(httpResponse, httpClient);
        }
    }

    /**
     * Description: 释放资源
     *
     * @param httpResponse
     * @param httpClient
     * @throws IOException
     */
    public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        // 释放资源
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }
}



