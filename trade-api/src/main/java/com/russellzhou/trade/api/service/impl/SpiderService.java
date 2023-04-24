package com.russellzhou.trade.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.russellzhou.trade.api.interfaces.request.QueryCrawledDataRequest;
import com.russellzhou.trade.api.interfaces.response.QueryCrawledDataResponse;
import com.russellzhou.trade.data.dao.SpiderInfoDao;
import com.russellzhou.trade.data.entity.SpiderInfo;
import com.russellzhou.trade.infrastructure.adapter.BaiLianAdapter;
import com.russellzhou.trade.infrastructure.adapter.request.SearchV5Request;
import com.russellzhou.trade.infrastructure.adapter.response.DetailV3Response;
import com.russellzhou.trade.infrastructure.adapter.response.SearchV5Response;
import com.russellzhou.trade.infrastructure.common.enums.BaiLianStoreEnum;
import com.russellzhou.trade.infrastructure.common.enums.BaiLianShopEnum;
import com.russellzhou.trade.infrastructure.common.enums.SpiderOperateTypeEnum;
import com.russellzhou.trade.infrastructure.common.enums.SpiderWebChannelEnum;
import com.russellzhou.trade.api.assembler.dao.SpiderInfoAssembler;
import com.russellzhou.trade.api.service.dto.spider.BaiLianSpiderAggregateInfoDto;
import com.russellzhou.trade.api.service.dto.spider.GetBaiLianCommodityDto;
import com.russellzhou.trade.infrastructure.utils.PriceUtils;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 09:57
 * @description： 爬虫相关的实现类
 * @version： v1.0
 */
@Service
public class SpiderService {

    private static Logger log = LoggerFactory.getLogger(SpiderService.class);

    private static final Integer PAGE_SIZE = 20;
    private static final String MEMBER_TOKEN = "92effc7b1724675c78ed40ba6e265ffa0748bec386906c4a86ab87e43f0da453d51e1124baeecedf";

    @Autowired
    private BaiLianAdapter baiLianAdapter;

    @Resource
    private SpiderInfoDao spiderInfoDao;

    /**
     * 聚合爬虫相关数据
     * @param dto
     * @return
     */
    public void crawlBaiLianCommodityInfo(GetBaiLianCommodityDto dto){
        BaiLianSpiderAggregateInfoDto baiLianSpiderAggregateInfoDto = new BaiLianSpiderAggregateInfoDto();
        //获取百联云店单个商铺的商品基本信息
        renderBaiLianBasicInfo(baiLianSpiderAggregateInfoDto, dto.getShopCode());
        //获取百联云店爬虫数据的额外信息
        renderBaiLianExtraInfo(baiLianSpiderAggregateInfoDto, dto.getOperateType(), dto.getUserName());
        spiderInfoDao.batchSaveSpiderInfo(SpiderInfoAssembler.convert2SpiderInfoEntity4Save(baiLianSpiderAggregateInfoDto));
    }

    /**
     * 获取百联云店单个商铺的商品基本信息
     * @param aggregateInfoDto
     * @param shopCodeList
     */
    private void renderBaiLianBasicInfo(BaiLianSpiderAggregateInfoDto aggregateInfoDto, List<String> shopCodeList) {
        List<BaiLianSpiderAggregateInfoDto.ProductInfoDto> productInfoDtoList = new ArrayList<>();
        for(String shopCode : shopCodeList){
            //当前商铺、商场、数据渠道的枚举类型
            BaiLianShopEnum shopEnum = BaiLianShopEnum.get(shopCode);
            BaiLianStoreEnum storeEnum = BaiLianStoreEnum.get(shopEnum.getStoreCode());
            //组装商铺信息
            BaiLianSpiderAggregateInfoDto.ShopInfoDto shopInfoDto = new BaiLianSpiderAggregateInfoDto.ShopInfoDto();
            shopInfoDto.setShopCode(shopEnum.getShopCode());
            shopInfoDto.setShopName(shopEnum.getShopName());
            aggregateInfoDto.setShopInfoDto(shopInfoDto);
            //组装商场信息
            BaiLianSpiderAggregateInfoDto.StoreInfoDto storeInfoDto = new BaiLianSpiderAggregateInfoDto.StoreInfoDto();
            storeInfoDto.setStoreCode(storeEnum.getStoreCode());
            storeInfoDto.setStoreName(storeEnum.getStoreName());
            aggregateInfoDto.setStoreInfoDto(storeInfoDto);
            //单个商铺是否遍历完毕的标识
            boolean overFlag = false;
            //初始页号
            int pageNo = 1;
            //商品总数
            int totalNum = 0;
            //当前处理第几个商品
            int order = 1;
            while(!overFlag){
                SearchV5Request searchV5Request = new SearchV5Request();
                searchV5Request.setPageNo(pageNo);
                searchV5Request.setPageSize(PAGE_SIZE);
                searchV5Request.setTimestamp(new Date());
                searchV5Request.setMemberToken(MEMBER_TOKEN);
                searchV5Request.setShopCode(shopCode);
                searchV5Request.setStoreCode(storeEnum.getStoreCode());
                searchV5Request.setStoreType(storeEnum.getStoreType());
                SearchV5Response searchV5Response = baiLianAdapter.searchCommodityByShop(searchV5Request);
                if(searchV5Response != null){
                    if(totalNum  == 0){
                        totalNum = Integer.valueOf(searchV5Response.getCount());
                    }
                    for(int i=0; i<searchV5Response.getResultCommodityList().size(); i++){
                        SearchV5Response.ResultCommodity rc = searchV5Response.getResultCommodityList().get(i);
                        log.info("百联云店爬虫 总计{}个商品 正在处理第{}个商品", totalNum, order);
                        //获取单个商品的属性
                        DetailV3Response detailV3Response = baiLianAdapter.searchSingleCommodityInfo(rc.getProductId());
                        //组装单商品的基本信息
                        BaiLianSpiderAggregateInfoDto.ProductInfoDto productInfoDto = new BaiLianSpiderAggregateInfoDto.ProductInfoDto();
                        productInfoDto.setProductId(rc.getProductId());
                        productInfoDto.setTitle(rc.getGoodsStandaName());
                        productInfoDto.setEnglishBrandName(rc.getBrandEnglishName());
                        productInfoDto.setChineseBrandName(rc.getBrandName());
                        productInfoDto.setImgUrl(rc.getImageUrl());
                        productInfoDto.setType(detailV3Response.getProductType());
                        productInfoDto.setSize(detailV3Response.getProductSize());
                        productInfoDto.setMarketPrice(rc.getMarketPrice());
                        productInfoDto.setDiscountPrice(rc.getGoodsPrice());
                        productInfoDto.setDiscount(rc.getDiscount());
                        productInfoDto.setDiscountMode(detailV3Response.getPromotionList());
                        productInfoDtoList.add(productInfoDto);
                        order ++;
                    }
                    overFlag = searchV5Response.getPageNo().equals(searchV5Response.getTotalPage());
                }
                pageNo ++ ;
            }
            aggregateInfoDto.setProductInfoDtoList(productInfoDtoList);
        }
    }

    /**
     * 获取百联云店爬虫数据的额外信息
     * @param aggregateInfoDto
     * @param operateType
     * @param userName
     */
    private void renderBaiLianExtraInfo(BaiLianSpiderAggregateInfoDto aggregateInfoDto, Integer operateType, String userName){
        BaiLianStoreEnum storeEnum = BaiLianStoreEnum.get(aggregateInfoDto.getStoreInfoDto().getStoreCode());
        SpiderWebChannelEnum channelEnum = SpiderWebChannelEnum.get(storeEnum.getWebChannelCode());
        aggregateInfoDto.setSource(channelEnum.getType());
        aggregateInfoDto.setOperatorType(SpiderOperateTypeEnum.get(operateType));
        aggregateInfoDto.setOperator(userName);
    }

    /**
     * 获取爬虫信息
     * @param request
     * @return
     */
    public QueryCrawledDataResponse queryCrawledData(QueryCrawledDataRequest request){
        QueryCrawledDataResponse response = new QueryCrawledDataResponse();
        List<QueryCrawledDataResponse.DataDetail> dataDetailList = new ArrayList<>();

        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        Map<String, Object> paramMap = new HashMap<>();
        if(request.getBrandList() != null && request.getBrandList().size() > 0){
            paramMap.put("brandList", request.getBrandList());
        }
        if(request.getStoreList() != null && request.getStoreList().size() > 0){
            paramMap.put("storeList", request.getStoreList());
        }
        paramMap.put("maxPrice", request.getMaxPrice());
        paramMap.put("minPrice", request.getMinPrice());
        paramMap.put("createdStartDate", request.getStartDate());
        paramMap.put("createdEndDate", request.getEndDate());
        if(request.getHasDiscount() != null){
            paramMap.put("hasDiscount", request.getHasDiscount() ? 1 : 0);
        }
        PageInfo<SpiderInfo> spiderInfoListByPage = new PageInfo<>(spiderInfoDao.querySpiderInfoListBySelective(paramMap));

        response.setPageNo(spiderInfoListByPage.getPageNum());
        response.setPageSize(spiderInfoListByPage.getPageSize());
        response.setTotalPage(spiderInfoListByPage.getPages());
        response.setTotalNum(spiderInfoListByPage.getSize());

        for(SpiderInfo spider : spiderInfoListByPage.getList()){
            QueryCrawledDataResponse.DataDetail detail = new QueryCrawledDataResponse.DataDetail();
            //商品信息
            detail.setBaiLianProductId(spider.getProductId());
            detail.setBrandEn(spider.getBrandEn());
            detail.setBrandZh(spider.getBrandZh());
            detail.setTitle(spider.getProductTitle());
            if(StringUtils.isNotEmpty(spider.getProductSize())){
                detail.setProductSize(Arrays.asList(spider.getProductSize().split(",")));
            }
            if(StringUtils.isNotEmpty(spider.getProductType())){
                detail.setProductType(Arrays.asList(spider.getProductType().split(",")));
            }
            detail.setImgUrl(spider.getImgUrl());
            detail.setMarketPrice(PriceUtils.changeFen2ChineseYuan(spider.getOriginPrice()));
            detail.setActualPrice(PriceUtils.changeFen2ChineseYuan(spider.getActualPrice()));
            //优惠信息
            QueryCrawledDataResponse.DiscountInfo discount = new QueryCrawledDataResponse.DiscountInfo();
            discount.setDiscount(String.valueOf(spider.getDiscount()));
            discount.setDiscountModeList(Arrays.asList(spider.getDiscountMode().split(",")));
            detail.setDiscountInfo(discount);
            //商场名称
            detail.setStoreName(spider.getStoreName());
            dataDetailList.add(detail);
        }
        response.setDataDetailList(dataDetailList);
        return response;
    }

}
