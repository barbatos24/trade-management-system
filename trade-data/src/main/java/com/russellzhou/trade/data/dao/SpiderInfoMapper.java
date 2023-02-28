package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.SpiderInfo;

public interface SpiderInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SpiderInfo row);

    int insertSelective(SpiderInfo row);

    SpiderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpiderInfo row);

    int updateByPrimaryKey(SpiderInfo row);
}