package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 14:05
 * @description： 百联云店商铺枚举
 * @version： v1.0
 */
@Getter
public enum BaiLianShopEnum {
    ADIDAS("3bb39d42d2884205bd426d4ad9994a06", "Adidas", "001304")
    ;

    /**
     * 商铺编号
     */
    private String shopCode;

    /**
     * 商铺名称
     */
    private String shopName;

    /**
     * 所在的商铺编号
     */
    private String storeCode;


    BaiLianShopEnum(String shopCode, String shopName, String storeCode) {
        this.shopCode = shopCode;
        this.shopName = shopName;
        this.storeCode = storeCode;
    }

    public static Map<String, BaiLianShopEnum> ENUM_MAP = new HashMap<>();
    public static List<String> ALL_BAI_LIAN_SHOP_CODE = new ArrayList<>();

    static {
        Stream.of(BaiLianShopEnum.values()).forEach(obj -> {
            ENUM_MAP.put(obj.shopCode, obj);
            ALL_BAI_LIAN_SHOP_CODE.add(obj.shopCode);
        });
    }

    public static BaiLianShopEnum get(String shopCode){
        return shopCode == null ? null : ENUM_MAP.get(shopCode);
    }
}
