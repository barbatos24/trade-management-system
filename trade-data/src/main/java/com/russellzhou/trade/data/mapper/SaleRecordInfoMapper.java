package com.russellzhou.trade.data.mapper;

import com.russellzhou.trade.data.entity.SaleRecordInfo;

public interface SaleRecordInfoMapper {

    int deleteByPrimaryKey(String saleRecordId);

    int insert(SaleRecordInfo row);

    int insertSelective(SaleRecordInfo row);

    SaleRecordInfo selectByPrimaryKey(String saleRecordId);

    int updateByPrimaryKeySelective(SaleRecordInfo row);

    int updateByPrimaryKey(SaleRecordInfo row);
}