package com.position.reptile;

import java.util.HashMap;
import java.util.Map;

public class HttpClientData {
    public static void main(String[] args) throws Exception {
        //设置请求头
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en-GB;q=0.8,en;q=0.7");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " + "AppleWebKit/537.36 (KHTML, like Gecko) " + "Chrome/75.0.3770.142 Safari/537.36");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Referer", "https://www.lagou.com/wn/jobs?cl=false&fromSearch=true&kd=%E5%A4%A7%E6%95%B0%E6%8D%AE");
        headers.put("Origin", "https://www.lagou.com");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("X-Anit-Forge-Token", "None");
        headers.put("Cache-Control", "no-cache");
        headers.put("X-Anit-Forge-Code", "0");
        headers.put("Host", "www.lagou.com");
        //设置请求参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd", "大数据");
        params.put("city", "全国");
        for (int i = 1; i < 31; i++) {
            params.put("pn", String.valueOf(i));
            HttpClientResp result = HttpClientUtils.doPost("https://www.lagou.com/jobs/v2/positionAjax.json?" + "needAddtionalResult=false&first=true&px=default", headers, params);
            System.out.println(result);
            HttpClientHdfsUtils.createFileBySysTime("hdfs://hadoop:8020", "page" + i, result.toString());
            Thread.sleep(500);

        }
    }
}
