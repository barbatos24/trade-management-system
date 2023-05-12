package com.russellzhou.trade.api.assembler.dao;

import com.russellzhou.trade.data.entity.SpiderInfo;
import com.russellzhou.trade.infrastructure.utils.CategoryUtils;
import com.russellzhou.trade.infrastructure.utils.PriceUtils;
import com.russellzhou.trade.api.service.dto.spider.BaiLianSpiderAggregateInfoDto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/26 09:55
 * @description： 爬虫相关Dto转化为db对象的实体类
 * @version： v1.0
 */
public class SpiderInfoAssembler {

    public static List<SpiderInfo> convert2SpiderInfoEntity4Save(BaiLianSpiderAggregateInfoDto baiLianSpiderAggregateInfoDto){
        List<SpiderInfo> spiderInfoList = new ArrayList<>();
        List<BaiLianSpiderAggregateInfoDto.ProductInfoDto> productInfoList = baiLianSpiderAggregateInfoDto.getProductInfoDtoList();
        BaiLianSpiderAggregateInfoDto.StoreInfoDto storeInfo = baiLianSpiderAggregateInfoDto.getStoreInfoDto();
        for(BaiLianSpiderAggregateInfoDto.ProductInfoDto product : productInfoList){
            SpiderInfo spiderInfo = new SpiderInfo();
            spiderInfo.setBlydPid(product.getProductId());
            spiderInfo.setBrandEn(product.getEnglishBrandName());
            spiderInfo.setBrandZh(product.getChineseBrandName());
            spiderInfo.setWebChannel(baiLianSpiderAggregateInfoDto.getSource());
            spiderInfo.setCategoryCode(CategoryUtils.classifyByProductTitle(product.getTitle()).getCode());
            spiderInfo.setProductTitle(product.getTitle());
            spiderInfo.setProductType(String.join(",", product.getType()));
            spiderInfo.setProductSize(String.join(",", product.getSize()));
            spiderInfo.setImgUrl(product.getImgUrl());
            spiderInfo.setOriginPrice(PriceUtils.changeYuan2Fen(product.getMarketPrice()));
            spiderInfo.setActualPrice(PriceUtils.changeYuan2Fen(product.getDiscountPrice()));
            spiderInfo.setLowestPriceFlag(0);
            spiderInfo.setDiscount(product.getDiscount());
            spiderInfo.setDiscountMode(String.join(",", product.getDiscountMode()));
            if(product.getDiscount() != null || StringUtils.isNotEmpty(spiderInfo.getDiscountMode())){
                spiderInfo.setHasDiscountFlag(1);
            } else {
                spiderInfo.setHasDiscountFlag(0);
            }
            spiderInfo.setStoreName(storeInfo.getStoreName());
            spiderInfo.setOperateType(baiLianSpiderAggregateInfoDto.getOperatorType().getType());
            spiderInfo.setOperator(baiLianSpiderAggregateInfoDto.getOperator());
            spiderInfo.setCreatedTime(new Date());
            spiderInfoList.add(spiderInfo);
        }
        return spiderInfoList;
    }
}
