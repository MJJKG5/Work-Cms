package com.gp.cms.model.entity;

public class ResApi<T> {
    /**
     * 编号
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 结果
     */
    private T result;

    public ResApi() {
        this.code = "200";
        this.msg = "ok";
        this.result = null;
    }

    public ResApi(T result) {
        this.code = "200";
        this.code = "ok";
        this.result = result;
    }

    public ResApi(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.result = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
