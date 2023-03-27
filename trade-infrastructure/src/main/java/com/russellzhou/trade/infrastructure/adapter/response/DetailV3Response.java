package com.russellzhou.trade.infrastructure.adapter.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 23:29
 * @version： v1.0
 */
@Setter
@Getter
public class DetailV3Response {

    /**
     * 商品款式
     */
    private List<String> productType;

    /**
     * 商品尺码/规格
     */
    private List<String> productSize;

    /**
     * 当前商品可以参与的优惠活动
     */
    private List<String> promotionList;

}
