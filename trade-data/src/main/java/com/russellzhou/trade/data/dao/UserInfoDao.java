package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.UserInfo;
import com.russellzhou.trade.data.mapper.UserInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 10:59
 * @version： v1.0
 */
@Repository
public class UserInfoDao {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public UserInfo queryUserInfoByUserName(String userName){
        return userInfoMapper.selectByUserAccount(userName);
    }

    /**
     * 保存用户信息
     */
    public void save(UserInfo userInfo){
        userInfoMapper.insert(userInfo);
    }
}
