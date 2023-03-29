package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 爬虫数据实体
 */
@Setter
@Getter
public class SpiderInfo {
    /**
     *   主键id
     */
    private Long id;

    /**
     *   商品id
     */
    private String productId;

    /**
     *   品牌名称（英文）
     */
    private String brandEn;

    /**
     *   品牌名称（中文）
     */
    private String brandZh;

    /**
     *   数据来源
     */
    private String webChannel;

    /**
     *   商品名称
     */
    private String productTitle;

    /**
     *   款式
     */
    private String productType;

    /**
     *   尺码/规格
     */
    private String productSize;

    /**
     *   商品图片
     */
    private String imgUrl;

    /**
     *   市场原价
     */
    private Long originPrice;

    /**
     *   实际价格
     */
    private Long actualPrice;

    /**
     *   是否历史最低价 0-否 1-是
     */
    private Integer lowestPriceFlag;

    /**
     *   折扣额度
     */
    private Double discount;

    /**
     *   优惠模式
     */
    private String discountMode;

    /**
     *   是否有优惠 0-没有 1-有
     */
    private Integer hasDiscountFlag;

    /**
     *   商铺信息
     */
    private String shopInfo;

    /**
     *   商场信息
     */
    private String storeInfo;

    /**
     * 运行类型
     */
    private Integer operateType;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 创建时间
     */
    private Date createdTime;

}