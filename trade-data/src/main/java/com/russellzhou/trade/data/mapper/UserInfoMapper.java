package com.russellzhou.trade.data.mapper;

import com.russellzhou.trade.data.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo userInfo);

    int insertSelective(UserInfo row);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo row);

    int updateByPrimaryKey(UserInfo row);

    UserInfo selectByUserAccount(@Param("userAccount") String userAccount);
}