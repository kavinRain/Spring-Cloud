package com.spring.cloud.common.enums;

/**
 * Created by Administrator on 2017/6/3.
 */
public enum ResultType {
    SUCCESS(10000, "业务处理成功!"),
    FAIL(10001, "业务处理失败!");

    private Integer code;

    private String msg;

    ResultType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
