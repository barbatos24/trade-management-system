package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.spiderInfo;

public interface spiderInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(spiderInfo row);

    int insertSelective(spiderInfo row);

    spiderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(spiderInfo row);

    int updateByPrimaryKey(spiderInfo row);
}