package com.russellzhou.trade.infrastructure.adapter.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 11:42
 * @description： 查询商品汇总信息的接口入参
 * @version： v1.0
 */
@Setter
@Getter
public class SearchV5Request {

    /**
     * 页号
     */
    private Integer pageNo;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 商铺编号
     */
    private String shopCode;

    /**
     * 商场类型
     */
    private String storeType;

    /**
     * 商场编号
     */
    private String storeCode;

    /**
     * 用户登录token
     */
    private String memberToken;

    /**
     * 当前时间戳
     */
    private Date timestamp;

    /**
     * 搜索tagid
     */
    private List<Object> searchTagIdList;

    /**
     * 过滤条件
     */
    private Filtration filtration;

    @Setter
    @Getter
    public static class Filtration{

        /**
         * 排序类型
         */
        private Integer sortType;

        /**
         * todo
         */
        private Integer promotionFlag;

        /**
         * todo
         */
        private Integer stockFlag;

        /**
         * 最高价格
         */
        private Integer maxPrice;

        /**
         * 最低价格
         */
        private Integer minPrice;
    }
}
