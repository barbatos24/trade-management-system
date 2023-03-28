package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户信息实体类
 */
@Setter
@Getter
public class UserInfo {
    /**
     *   自增id
     */
    private Long id;

    /**
     *   账户名称
     */
    private String userAccount;

    /**
     *   用户密码
     */
    private String userPassword;

    /**
     *   用户姓名
     */
    private String userName;

    /**
     *   邮箱
     */
    private String email;

    /**
     *   手机号
     */
    private String mobile;

    /**
     *   是否删除
     */
    private Integer isDel;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   修改时间
     */
    private Date modifyTime;

}