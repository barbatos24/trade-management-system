package com.russellzhou.trade.api.interfaces;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.russellzhou.trade.api.request.RegisterRequest;
import com.russellzhou.trade.api.request.VerifyLoginRequest;
import com.russellzhou.trade.infrastructure.common.exception.TmsException;
import com.russellzhou.trade.infrastructure.common.exception.TmsExceptionMessage;
import com.russellzhou.trade.infrastructure.utils.ResponseVO;
import com.russellzhou.trade.service.impl.UserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static final Logger log = LoggerFactory.getLogger(UserApi.class);

    @Resource
    private UserService userService;

    /**
     * 用户登录验证
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseVO<Void> login(@RequestBody VerifyLoginRequest request){
        log.info("用户登入校验 login 用户名:{} 密码:{}", request.getAccount(), request.getPassword());
        String account = request.getAccount();
        String password = request.getPassword();
        try{
            userService.login(account, password);
            //StpUtil.login(account);
        }catch (TmsException e){
            log.error("用户登入校验不通过 message:{}", e.getMessage());
            return new ResponseVO(e.getCode(), e.getMessage());
        }catch (Exception e){
            log.error("用户登入校验发生异常 message:{}", e.getMessage());
            return new ResponseVO(TmsExceptionMessage.SYSTEM_EXCEPTION.code, TmsExceptionMessage.SYSTEM_EXCEPTION.getMessage());
        }
        return ResponseVO.ofSuccess(null);
    }

    /**
     * 新用户注册
     * @return
     */
    @PostMapping(value = "/register")
    public ResponseVO<Void> register(@RequestBody RegisterRequest request){
        log.info("用户注册 register 入参:{}", JSON.toJSONString(request));
        userService.register(request.getUserAccount(),request.getPassword(), request.getUserName(), request.getEmail(), request.getMobile());
        return ResponseVO.ofSuccess(null);
    }
}
