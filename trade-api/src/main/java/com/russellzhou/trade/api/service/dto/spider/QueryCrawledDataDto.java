package com.russellzhou.trade.api.service.dto.spider;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 17:36
 * @version： v1.0
 */
@Setter
@Getter
public class QueryCrawledDataDto {

    /**
     * 品牌名称(英文)
     */
    private String brandName;

    /**
     * 最高价格
     */
    private Long maxPrice;

    /**
     * 最低价格
     */
    private Long minPrice;

    /**
     * 商场名称
     */
    private String storeName;

    /**
     * 是否有优惠
     */
    private Boolean hasDiscount;

}
