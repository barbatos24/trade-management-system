package com.russellzhou.trade.service.impl;

import com.russellzhou.trade.data.dao.UserInfoDao;
import com.russellzhou.trade.data.entity.UserInfo;
import com.russellzhou.trade.infrastructure.common.enums.IsDelEnum;
import com.russellzhou.trade.infrastructure.common.exception.TmsException;
import com.russellzhou.trade.infrastructure.common.exception.TmsExceptionMessage;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 10:51
 * @version： v1.0
 */
@Service
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserInfoDao userInfoDao;

    public void login(String account, String password){
        UserInfo userInfo = userInfoDao.queryUserInfoByUserName(account);
        if(Objects.isNull(userInfo) || IsDelEnum.YES.getCode().equals(userInfo.getIsDel())){
            throw new TmsException(TmsExceptionMessage.ACCOUNT_NOT_EXIST);
        }
        if(!account.equals(userInfo.getUserAccount()) || !password.equals(userInfo.getUserPassword())){
            throw new TmsException(TmsExceptionMessage.PASSWORD_INCORRECT);
        }
    }

    public void register(String userAccount, String password, String userName, String email, String mobile){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAccount(userAccount);
        userInfo.setUserPassword(password);
        userInfo.setUserName(userName);
        userInfo.setEmail(email);
        userInfo.setMobile(mobile);
        userInfo.setIsDel(IsDelEnum.NO.getCode());
        userInfo.setCreateTime(new Date());
        userInfo.setModifyTime(new Date());
        userInfoDao.save(userInfo);
    }


}
