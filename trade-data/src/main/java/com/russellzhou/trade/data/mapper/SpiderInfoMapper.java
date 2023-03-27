package com.russellzhou.trade.data.mapper;

import com.russellzhou.trade.data.entity.SpiderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpiderInfoMapper {

    int insert(SpiderInfo row);

    int batchInsert(List<SpiderInfo> list);

    int insertSelective(SpiderInfo row);
}