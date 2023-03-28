package com.russellzhou.trade.infrastructure.common.exception;

import lombok.Getter;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 10:06
 * @description： 错误码
 * @version： v1.0
 */
@Getter
public enum TmsExceptionMessage {
    SUCCESS(200,"操作成功", "操作成功"),
    SYSTEM_EXCEPTION(500, "系统异常","系统异常"),

    /****************************************************************************用户相关****************************************************************************/
    ACCOUNT_NOT_EXIST(1001, "用户不存在", "未检测到此用户名，请确认后重新输入"),
    PASSWORD_INCORRECT(1002, "密码错误", "密码输入错误,请确认后重试"),
    ;

    public final Long code;

    public final String innerMsg;

    public final String message;

    TmsExceptionMessage(long code, String innerMsg, String message) {
        this.code = code;
        this.innerMsg = innerMsg;
        this.message = message;
    }
}
