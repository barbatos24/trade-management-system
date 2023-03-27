package com.russellzhou.trade.infrastructure.utils;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 14:54
 * @description： 百联云店的接口Result
 * @version： v1.0
 */
public class BailianResult<T> {
    private Integer resCode;
    private String msg;
    private T obj;

    public BailianResult() {
        super();
    }

    public BailianResult(Integer resCode, String msg, T obj) {
        this.resCode = resCode;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
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

    @Override
    public String toString() {
        return "BailianResult{" +
                "resCode=" + resCode +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
