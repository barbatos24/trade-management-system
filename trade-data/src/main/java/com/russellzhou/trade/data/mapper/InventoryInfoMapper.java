package com.russellzhou.trade.data.mapper;

import com.russellzhou.trade.data.entity.InventoryInfo;

public interface InventoryInfoMapper {

    int deleteByPrimaryKey(String inventoryId);

    int insert(InventoryInfo row);

    int insertSelective(InventoryInfo row);

    InventoryInfo selectByPrimaryKey(String inventoryId);

    int updateByPrimaryKeySelective(InventoryInfo row);

    int updateByPrimaryKey(InventoryInfo row);
}