package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 库存消息实体类
 */
@Getter
@Setter
public class InventoryInfo {
    /**
     *   自增id
     */
    private Long id;

    /**
     *   库存编号
     */
    private String inventoryId;

    /**
     *   spu编号
     */
    private Long spuId;

    /**
     *   sku编号
     */
    private Long skuId;

    /**
     *   当前数量
     */
    private Integer currentNum;

    /**
     *   仓库编号
     */
    private String warehouseCode;

    /**
     *   仓库地址
     */
    private String warehouseAddress;

    /**
     *   价格
     */
    private Integer price;

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