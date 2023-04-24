package com.russellzhou.trade.api.interfaces.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @ApiModelProperty(value = "页号)")
    private Integer pageNo;

    @ApiModelProperty(value = "页大小)")
    private Integer pageSize;

    @ApiModelProperty(value = "品牌名称(英文)列表")
    private List<String> brandList;

    @ApiModelProperty(value = "商场列表")
    private List<String> storeList;

    @ApiModelProperty(value = "最高价格")
    private Long maxPrice;

    @ApiModelProperty(value = "最低价格")
    private Long minPrice;

    @ApiModelProperty(value = "是否有优惠")
    private Boolean hasDiscount;

    @ApiModelProperty(value = "爬虫执行开始日期")
    private Date startDate;

    @ApiModelProperty(value = "爬虫执行结束日期")
    private Date endDate;
}
