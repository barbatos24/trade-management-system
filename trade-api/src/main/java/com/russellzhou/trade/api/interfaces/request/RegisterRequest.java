package com.russellzhou.trade.api.interfaces.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 14:10
 * @description： 注册新用户的入参
 * @version： v1.0
 */
@Setter
@Getter
public class RegisterRequest implements Serializable {

    private static final long serialVersionUID = 8914100515641279435L;

    @ApiModelProperty(value = "用户名")
    @Size(max = 20, message = "用户名长度不能大于20")
    private String userAccount;

    @ApiModelProperty(value = "密码")
    @Size(max = 20, message = "密码长度不能大于20")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String userName;

    @ApiModelProperty(value = "电子邮箱")
    @Email
    private String email;

    @ApiModelProperty(value = "移动电话")
    @Pattern(regexp = "\\d{11}",message = "必须为数字，并且长度为11")
    private String mobile;
}
