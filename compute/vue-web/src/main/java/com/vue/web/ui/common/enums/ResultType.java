package com.vue.web.ui.common.enums;

/**
 * Created by Administrator on 2017/6/2.
 */
public enum ResultType{
    SUCCESS(10000, "请求处理成功!"),
    FAIL(10001, "请求处理失败!");


    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
