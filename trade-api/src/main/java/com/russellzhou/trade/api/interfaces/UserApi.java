package com.russellzhou.trade.api.interfaces;

import com.russellzhou.trade.infrastructure.utils.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zhoudewei
 * @date： 2023/2/28 17:36
 * @description： 用户相关的api
 * @version： v1.0
 */
@RestController
@RequestMapping(value = "/userApi")
public class UserApi {

    /**
     * 用户登录验证
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseVO<Void> login(){
        return null;
    }

    /**
     * 新用户注册
     * @return
     */
    @PostMapping(value = "/register")
    public ResponseVO<Void> register(){
        return null;
    }
}
