package com.russellzhou.trade.api.interfaces.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 09:21
 * @description：getOutletsCommodityInfoByStore的接口入参
 * @version： v1.0
 */
@Setter
@Getter
public class BaiLianCommodityInfoRequest implements Serializable {

    private static final long serialVersionUID = 3562877451656605273L;

    @ApiModelProperty(value = "操作类型 1-定时任务脚本 2-手动执行")
    private Integer operateType;

    @ApiModelProperty(value = "操作人的用户名")
    private String userName;

    @ApiModelProperty(value = "商铺编号")
    private String shopCode;

}
