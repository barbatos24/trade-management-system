package com.russellzhou.trade.api.interfaces.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 16:49
 * @description：
 * @version： v1.0
 */
@Getter
@Setter
public class QueryCrawledDataResponse implements Serializable {

    private static final long serialVersionUID = 6506450291738614856L;

    @ApiModelProperty(value = "数据详情")
    private List<DataDetail> dataDetailList;


    @Setter
    @Getter
    public static class DataDetail{

        @ApiModelProperty("百联云店商品编号")
        private String baiLianProductId;

        @ApiModelProperty(value = "品牌名称(英文)")
        private String brandEn;

        @ApiModelProperty(value = "品牌名称(中文)")
        private String brandZh;

        @ApiModelProperty(value = "产品名称")
        private String title;

        @ApiModelProperty(value = "规格/尺码")
        private List<String> productSize;

        @ApiModelProperty(value = "款式")
        private List<String> productType;

        @ApiModelProperty(value = "产品图片")
        private String imgUrl;

        @ApiModelProperty(value = "市场零售价")
        private String marketPrice;

        @ApiModelProperty(value = "实际价格")
        private String actualPrice;

        @ApiModelProperty(value = "优惠信息")
        private DiscountInfo discountInfo;

        @ApiModelProperty(value = "商场信息")
        private StoreInfo storeInfo;
    }

    @Setter
    @Getter
    public static class DiscountInfo{

        @ApiModelProperty(value = "折扣力度")
        private String discount;

        @ApiModelProperty(value = "优惠模式")
        private List<String> discountModeList;
    }

    @Setter
    @Getter
    public static class StoreInfo{

        @ApiModelProperty(value = "商场名称")
        private String storeName;

        @ApiModelProperty(value = "商场地址")
        private String storeAddress;
    }
}