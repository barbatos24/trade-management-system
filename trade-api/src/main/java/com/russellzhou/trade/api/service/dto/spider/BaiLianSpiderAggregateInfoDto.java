package com.russellzhou.trade.api.service.dto.spider;

import com.russellzhou.trade.infrastructure.common.enums.SpiderOperateTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 10:21
 * @description： 百联云店爬虫聚合信息dto
 * @version： v1.0
 */
@Setter
@Getter
public class BaiLianSpiderAggregateInfoDto {

    /**
     * 数据来源
     */
    private String source;

    /**
     * 操作类型
     */
    private SpiderOperateTypeEnum operatorType;

    /**
     * 操作人用户名
     */
    private String operator;

    /**
     * 商品信息
     */
    private List<ProductInfoDto> productInfoDtoList;

    /**
     * 商铺信息
     */
    private ShopInfoDto shopInfoDto;

    /**
     * 商场信息
     */
    private StoreInfoDto storeInfoDto;

    @Setter
    @Getter
    public static class ProductInfoDto{

        private String productId;

        private String title;

        private String englishBrandName;

        private String chineseBrandName;

        private String imgUrl;

        private List<String> type;

        private List<String> size;

        private Float marketPrice;

        private Float discountPrice;

        private Double discount;

        private List<String> discountMode;
    }

    @Getter
    @Setter
    public static class ShopInfoDto{

        private String shopCode;

        private String shopName;

        private String discountMode;
    }

    @Getter
    @Setter
    public static class StoreInfoDto{

        private String storeCode;

        private String storeName;
    }

}
