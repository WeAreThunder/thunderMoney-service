package com.thunder.money.entity.BASE;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class RestFul<T> implements Serializable {
    private static final String OK = "";
    private static final String ERROR = "error";

    private boolean success;
    private String message;
    private int code;
    private T data;
    private String err;

    public RestFul<T> success() {
        this.success = true;
        this.message = OK;
        return this;
    }

    public RestFul<T> failure() {
        this.success = false;
        this.message = ERROR;
        return this;
    }

    public RestFul<T> failure(String message) {
        this.success = false;
        this.message = message;
        return this;
    }

    public  static RestFul fail(String message) {
        RestFul r=new RestFul();
        r.success = false;
        r.message = message;
        r.err=message;
        return r;
    }
    public RestFul<T> data(T data) {
        this.data = data;
        return this;
    }

    public RestFul<T> code(int code) {
        this.code = code;
        return this;
    }

    public static  <T> RestFul<T> s(T t){
        return new RestFul<T>().success().code(HttpStatus.OK.value()).data(t);
    }
    public static  <T> RestFul<T> mAnds(String message,T t){
        return new RestFul<T>().success().code(HttpStatus.OK.value()).data(t).message(message);
    }
    

    public static  <T> RestFul<T> s(){
        return new RestFul<T>().success().code(HttpStatus.OK.value());
    }

    public RestFul<T> message(String message) {
        this.message = message;
        return this;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
