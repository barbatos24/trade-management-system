package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.SpiderInfo;
import com.russellzhou.trade.data.mapper.SpiderInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 17:07
 * @version： v1.0
 */
@Repository
public class SpiderInfoDao {

    @Resource
    private SpiderInfoMapper spiderInfoMapper;

    /**
     * 批量保存爬虫爬到的数据
     * @param list
     */
    public void batchSaveSpiderInfo(List<SpiderInfo> list){
        spiderInfoMapper.batchInsert(list);
    }
}
