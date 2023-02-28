package com.russellzhou.trade.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 销售记录实体类
 */
@Getter
@Setter
public class SaleRecordInfo {

    /**
     *   自增id
     */
    private Long id;

    /**
     *   销售记录编号
     */
    private String saleRecordId;

    /**
     *   库存编号
     */
    private String inventoryId;

    /**
     *   sku编号
     */
    private Long skuId;

    /**
     *   订单编号
     */
    private String orderNo;

    /**
     *   销售平台
     */
    private Byte platform;

    /**
     *   出价金额
     */
    private Integer bidPrice;

    /**
     *   技术服务费
     */
    private Integer techServiceFee;

    /**
     *   转账手续费
     */
    private Integer transferServiceFee;

    /**
     *   操作服务费
     */
    private Integer operateServiceFee;

    /**
     *   卖家出资邮费
     */
    private Integer postageFee;

    /**
     *   优惠金额
     */
    private Integer discountFee;

    /**
     *   预估到手价格
     */
    private Integer estimatePrice;

    /**
     *   实际到手金额
     */
    private Integer actualPrice;

    /**
     *   买家姓名
     */
    private String buyerName;

    /**
     *   买家收件地址
     */
    private String buyerAddress;

    /**
     *   买家手机号
     */
    private String buyerMobile;

    /**
     *   快递承运公司
     */
    private Byte expressCarrier;

    /**
     *   发货时间
     */
    private Date sendTime;

    /**
     *   买家是否签收
     */
    private Byte hasReceivedFlag;

    /**
     *   买家签收时间
     */
    private Date receivedTime;

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