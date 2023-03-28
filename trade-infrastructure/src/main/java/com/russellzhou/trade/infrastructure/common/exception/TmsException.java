package com.russellzhou.trade.infrastructure.common.exception;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 10:10
 * @description： tms自定义异常
 * @version： v1.0
 */
public class TmsException extends RuntimeException{

    private Long code;
    private String message;
    private Object data;
    private Throwable cause;

    public TmsException() {
    }

    public TmsException(TmsExceptionMessage tmsExceptionMessage) {
        this.code = tmsExceptionMessage.code;
        this.message = tmsExceptionMessage.message;
    }

    public TmsException(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public TmsException(Long code, String message, Object data, Throwable cause) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.cause = cause;
    }

    public Long getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
