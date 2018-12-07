package com.darren.architect_day36.retrofit;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class BaseResult<T> {
    String code;
    String msg;
    T data;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public boolean isOk(){
        return "200".equals(code);
    }
}
