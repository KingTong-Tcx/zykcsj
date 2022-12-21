package com.position.reptile;

import java.io.Serializable;

public class HttpClientResp implements Serializable {

    /**
     * 封装响应状态码及响应数据
     */
    private static final long serialVersionUID = -2224539827395038194L;
    //响应状态码
    private int code;
    //响应数据
    private String content;

    //生成空参方法，Alt+Shift+S
    public HttpClientResp() {
        super();
    }

    public HttpClientResp(int code) {
        this.code = code;
    }

    public HttpClientResp(String content) {
        this.content = content;
    }

    public HttpClientResp(int code, String content) {
        this.code = code;
        this.content = content;
    }

    //生成getter/setter方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpClientResp [code=" + code + ", content=" + content + "]";
    }


}
