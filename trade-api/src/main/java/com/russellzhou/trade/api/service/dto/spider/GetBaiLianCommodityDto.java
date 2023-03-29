package com.russellzhou.trade.api.service.dto.spider;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 11:29
 * @description：
 * @version： v1.0
 */
@Setter
@Getter
public class GetBaiLianCommodityDto extends BaseSpiderDto{

    /**
     * 商铺编号
     */
    private List<String> shopCode;

}
