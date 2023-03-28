package com.russellzhou.trade.infrastructure.adapter;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.russellzhou.trade.infrastructure.adapter.request.SearchV5Request;
import com.russellzhou.trade.infrastructure.adapter.response.DetailV3Response;
import com.russellzhou.trade.infrastructure.adapter.response.SearchV5Response;
import com.russellzhou.trade.infrastructure.common.constant.ExternalApiHost;
import com.russellzhou.trade.infrastructure.common.constant.ExternalApiPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 15:03
 * @description：outlets接口防腐层
 * @version： v1.0
 */
@Component
public class BaiLianAdapter {

    private static Logger log = LoggerFactory.getLogger(BaiLianAdapter.class);

    /**
     * 查询当前商铺的所有商品
     * @param request
     * @return
     */
    public SearchV5Response searchCommodityByShop(SearchV5Request request){
        if(Objects.isNull(request)){
            log.error("searchCommodityByShop request is null");
            return null;
        }
        String responseStr = HttpUtil.createPost(ExternalApiHost.BAI_LIAN_CLOUD_HOST + ExternalApiPath.BAI_LIAN_SEARCH_V5).body(JSONObject.toJSONString(request)).execute().body();
        JSONObject response = JSONObject.parseObject(responseStr);
        if(Objects.isNull(response) || !"00100000".equals(response.getString("resCode"))){
            log.error("Search outlets commodity went wrong ");
            return null;
        }
        SearchV5Response searchV5Response = new SearchV5Response();
        List<SearchV5Response.ResultCommodity> resultCommodityList = new ArrayList<>();
        //分页数据
        JSONObject dataObj = response.getJSONObject("obj");
        searchV5Response.setPageNo(dataObj.getString("pageNo"));
        searchV5Response.setPageSize(dataObj.getString("pageSize"));
        searchV5Response.setTotalPage(dataObj.getString("totalPage"));
        searchV5Response.setCount(dataObj.getString("count"));
        //商品数据
        JSONArray dataResultList = dataObj.getJSONArray("resultList");
        Iterator<Object> it = dataResultList.iterator();
        while(it.hasNext()){
            JSONObject resultObj = (JSONObject) it.next();
            JSONObject resultCommodityObj = resultObj.getJSONObject("resultCommodity");
            SearchV5Response.ResultCommodity rc = new SearchV5Response.ResultCommodity();
            rc.setProductId(resultCommodityObj.getString("productId"));
            rc.setGoodsStandaName(resultCommodityObj.getString("goodsStandaName"));
            rc.setImageUrl(resultCommodityObj.getString("imageUrl"));
            rc.setMarketPrice(resultCommodityObj.getFloat("marketPrice"));
            rc.setGoodsPrice(resultCommodityObj.getFloat("goodsPrice"));
            rc.setIsAvailable("1".equals(resultCommodityObj.getString("isAvailable")));
            rc.setOnSaleDate(resultCommodityObj.getDate("onSaleDate"));
            rc.setDiscount(resultCommodityObj.getDouble("discount"));
            rc.setDiscountShowFlag(resultCommodityObj.getInteger("discountShowFlag").equals(1));
            rc.setBrandName(resultCommodityObj.getString("brandName"));
            rc.setBrandEnglishName(resultCommodityObj.getString("brandEnglishName"));
            resultCommodityList.add(rc);
        }
        searchV5Response.setResultCommodityList(resultCommodityList);
        return searchV5Response;
    }

    /**
     * 查询单个商品的详细信息
     * @param productId
     */
    public DetailV3Response searchSingleCommodityInfo(String productId){
        if(productId == null || "".equalsIgnoreCase(productId)){
            log.error("searchSingleCommodityInfo productId is null");
        }
        String responseStr = HttpUtil.createGet(ExternalApiHost.BAI_LIAN_CLOUD_HOST + ExternalApiPath.BAI_LIAN_DETAIL_V3 + "/" + productId)
                                    .execute()
                                    .body();
        JSONObject response = JSONObject.parseObject(responseStr);
        if(Objects.isNull(response) || !"00100000".equals(response.getString("resCode"))){
            log.error("Search outlets commodity went wrong ");
            return null;
        }
        DetailV3Response detailV3Response = new DetailV3Response();
        //款式和尺码规格
        JSONObject dataDynamicAttrs = response.getJSONObject("obj").getJSONObject("goodsBasicInfoVO").getJSONObject("dynamicAttrs");
        Set<String> attrKeySet = dataDynamicAttrs.keySet();
        for(String key : attrKeySet){
            JSONObject attr = dataDynamicAttrs.getJSONObject(key);
            String categoryName = attr.getString("categoryName");
            List<String> attrList = new ArrayList<>();
            for(int i=0; i<attr.getJSONArray("attributes").size(); i++){
                attrList.add(attr.getJSONArray("attributes").getJSONObject(i).getString("attributeName"));
            }
            switch (categoryName){
                case "尺码":
                    detailV3Response.setProductSize(attrList);
                    break;
                case "颜色":
                    detailV3Response.setProductType(attrList);
                    break;
            }
        }
        //优惠活动
        List<String> promotionList = new ArrayList<>();
        JSONArray promotionArr = response.getJSONObject("obj").getJSONObject("goodsBasicInfoVO").getJSONArray("promotionList");
        for(int i=0; i<promotionArr.size(); i++){
            promotionList.add(promotionArr.getJSONObject(i).getString("promotionName"));
        }
        detailV3Response.setPromotionList(promotionList);
        return detailV3Response;
    }
}
