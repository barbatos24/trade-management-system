package com.russellzhou.trade.data.mapper;

import com.russellzhou.trade.data.entity.SpiderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpiderInfoMapper {

    int insert(SpiderInfo row);

    int batchInsert(List<SpiderInfo> list);

    List<SpiderInfo> selectBySelective(Map<String, Object> map);
}