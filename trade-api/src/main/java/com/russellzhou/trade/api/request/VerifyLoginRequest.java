package com.russellzhou.trade.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 10:41
 * @description： 登录校验的入参
 * @version： v1.0
 */
@Setter
@Getter
public class VerifyLoginRequest implements Serializable {

    private static final long serialVersionUID = -7317199704245501847L;

    @ApiModelProperty(value = "用户名")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;
}
