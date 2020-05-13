package com.immoc.miaosha.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.immoc.miaosha.domain.User;

import java.io.Serializable;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class Result<T> implements Serializable {
    private int code ;
    private String message;
    private T data;
    private Boolean result;

    public static<T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public int getCode () {
        return code ;
    }

    public void setCode(int code) {
        this.code  = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }


    public Result(int code ){
        this.code  = code ;
    }
    public Result(int code , T data){
        this.code  = code ;
        this.data = data;
    }

    public Result(T data){
//        this.code  = code ;
        this.data = data;
    }

    public Result(int status, String message, T data){
        this.code  = status;
        this.message = message;
        this.data = data;
    }


    public Result(int code , String message){
        this.code  = code ;
        this.message = message;
    }

    public Result(String message){
//        this.code  = code ;
        this.message = message;
    }
}
