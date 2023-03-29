package com.russellzhou.trade.api.interfaces.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 16:30
 * @description：
 * @version： v1.0
 */
@Getter
@Setter
public class QueryCrawledDataRequest implements Serializable {
    private static final long serialVersionUID = -971990944177790938L;

    @ApiModelProperty(value = "品牌名称(英文)")
    private String brandName;

    @ApiModelProperty(value = "最高价格")
    private Long maxPrice;

    @ApiModelProperty(value = "最低价格")
    private Long minPrice;

    @ApiModelProperty(value = "商场名称")
    private String storeName;

    @ApiModelProperty(value = "是否有优惠")
    private Boolean hasDiscount;
}
