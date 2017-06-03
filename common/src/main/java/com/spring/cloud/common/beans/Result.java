package com.spring.cloud.common.beans;


import com.spring.cloud.common.enums.ResultType;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Result<T extends Object> {

    private Integer code;

    private String msg;

    private T obj;

    public Result(ResultType resultType, T t) {
        code = resultType.getCode();
        msg = resultType.getMsg();
        obj = t;
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

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
