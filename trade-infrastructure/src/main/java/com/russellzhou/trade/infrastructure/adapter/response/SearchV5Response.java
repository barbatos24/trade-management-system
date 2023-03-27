package com.russellzhou.trade.infrastructure.adapter.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 15:05
 * @version： v1.0
 */
@Setter
@Getter
public class SearchV5Response {

    /**
     * 当前页号
     */
    private String pageNo;
    /**
     * 当前页大小
     */
    private String pageSize;
    /**
     * 总共页数
     */
    private String totalPage;
    /**
     * 总共商品数
     */
    private String count;

    /**
     * 商品明细
     */
    private List<ResultCommodity> resultCommodityList;

    @Setter
    @Getter
    public static class ResultCommodity{
        /**
         * 商品id
         */
        private String productId;
        /**
         * 商品名称
         */
        private String goodsStandaName;
        /**
         * 商品图片
         */
        private String imageUrl;
        /**
         * 市场价即原价
         */
        private Float marketPrice;
        /**
         * 折扣价格
         */
        private Float goodsPrice;
        /**
         * 是否可以购买
         */
        private Boolean isAvailable;
        /**
         * 折扣开始日期
         */
        private Date onSaleDate;
        /**
         * 折扣力度
         */
        private Double discount;
        /**
         * 是否折扣
         */
        private Boolean discountShowFlag;
        /**
         * 品牌名称
         */
        private String brandName;
        /**
         * 品牌名称 英文
         */
        private String brandEnglishName;
    }

}
