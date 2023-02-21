package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class spiderInfo {
    private Long id;

    private Long spuId;

    private Long skuId;

    private String webChannel;

    private String skuBrand;

    private String skuTitle;

    private Byte skuType;

    private String skuSize;

    private String skuSizeUnit;

    private Byte skuColor;

    private String skuImg;

    private Long currentPrice;

    private Byte lowestPriceFlag;

    private String skuPruchaseUrl;

    private String spuPurchaseUrl;

    private Long storeId;

    private String storeName;

    private Byte storeHasDiscountFlag;

    private String storeUrl;

    private Byte isDel;

    private Date createTime;

    private Date modifyTime;
}