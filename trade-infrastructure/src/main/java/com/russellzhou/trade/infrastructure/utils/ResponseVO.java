package com.russellzhou.trade.infrastructure.utils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author： zhoudewei
 * @date： 2023/2/21 13:48
 * @description： tms系统接口最外层通用返回类
 * @version： v1.0
 */
public class ResponseVO<T> implements Serializable {
    private static final long serialVersionUID = 1964465231096418758L;
    public static final Long SUCCESS_CODE = 200L;
    public static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private Long code;
    private String msg;
    private T data;

    public ResponseVO() {
        this.setCode(SUCCESS_CODE);
        this.setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public ResponseVO(T data) {
        this.setData(data);
        this.setCode(SUCCESS_CODE);
        this.setMsg("success");
    }

    public ResponseVO(Long code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseVO(Long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVO<T> ofSuccess(T data) {
        return new ResponseVO(data);
    }

    public static boolean isSuccess(ResponseVO result) {
        return !Objects.isNull(result) && SUCCESS_CODE.equals(result.getCode());
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
