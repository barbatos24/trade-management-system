package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 商品爬虫结果实体类
 */
@Getter
@Setter
public class SpiderInfo {
    /**
     *   主键id
     */
    private Long id;

    /**
     *   spu编号
     */
    private Long spuId;

    /**
     *   商品编号
     */
    private Long skuId;

    /**
     *   数据来源站点
     */
    private String webChannel;

    /**
     *   商品品牌
     */
    private String skuBrand;

    /**
     *   商品名称
     */
    private String skuTitle;

    /**
     *   商品类别，鞋、衣服等
     */
    private Byte skuType;

    /**
     *   商品尺码
     */
    private String skuSize;

    /**
     *   商品尺码单位
     */
    private String skuSizeUnit;

    /**
     *   商品颜色
     */
    private String skuColor;

    /**
     *   商品图片
     */
    private String skuImg;

    /**
     *   当前价格
     */
    private Integer skuPrice;

    /**
     *   是否历史最低价
     */
    private Byte lowestPriceFlag;

    /**
     *   Sku购买链接
     */
    private String skuPruchaseUrl;

    /**
     *   Spu购买链接
     */
    private String spuPurchaseUrl;

    /**
     *   适用性别
     */
    private Byte sex;

    /**
     *   是否是成人款
     */
    private Byte adultFlag;

    /**
     *   店铺编号
     */
    private Long storeId;

    /**
     *   店铺名称
     */
    private String storeName;

    /**
     *   当前店铺是否存在优惠
     */
    private Byte storeHasDiscountFlag;

    /**
     *   店铺链接
     */
    private String storeUrl;

    /**
     *   是否删除
     */
    private Byte isDel;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   修改时间
     */
    private Date modifyTime;

}