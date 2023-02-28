package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.UserInfo;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo row);

    int insertSelective(UserInfo row);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo row);

    int updateByPrimaryKey(UserInfo row);
}