package com.russellzhou.trade.data.dao;

import com.russellzhou.trade.data.entity.SpiderInfo;
import com.russellzhou.trade.data.mapper.SpiderInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据条件查询爬虫信息
     * @return
     */
    public List<SpiderInfo> querySpiderInfoListBySelective(Map<String, Object> map){
        return spiderInfoMapper.selectBySelective(map);
    }

    /**
     * 查询所有品牌
     * @return
     */
    public List<String> queryBrandList(){
        return spiderInfoMapper.selectBrandList();
    }

    /**
     * 查询所有商场名称
     * @return
     */
    public List<String> queryStoreNameList(){
        return spiderInfoMapper.selectStoreNameList();
    }
}
