package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 14:10
 * @description： 百联云店商场枚举
 * @version： v1.0
 */
@Getter
public enum BaiLianStoreEnum {
    QING_PU_OUTLETS("001304", "百联奥特莱斯广场（上海·青浦）", "1030", "上海市青浦区沪青平公路2888号（嘉松中路5555号）", 1000)
    ;

    /**
     * 商场编号
     */
    private String storeCode;

    /**
     * 商场名称
     */
    private String storeName;

    /**
     * 商场类型
     */
    private String storeType;

    /**
     * 商场地址
     */
    private String storeAddress;

    /**
     * 数据来源编号
     */
    private Integer webChannelCode;

    BaiLianStoreEnum(String storeCode, String storeName, String storeType, String storeAddress, Integer webChannelCode) {
        this.storeCode = storeCode;
        this.storeName = storeName;
        this.storeType = storeType;
        this.storeAddress = storeAddress;
        this.webChannelCode = webChannelCode;
    }

    public static Map<String, BaiLianStoreEnum> ENUM_MAP = new HashMap<>();
    public static List<String> ALL_BAI_LIAN_STORE_CODE = new ArrayList<>();

    static {
        Stream.of(BaiLianStoreEnum.values()).forEach(obj -> {
            ENUM_MAP.put(obj.storeCode, obj);
            ALL_BAI_LIAN_STORE_CODE.add(obj.storeCode);
        });
    }

    public static BaiLianStoreEnum get(String storeCode){
        return storeCode == null ? null : ENUM_MAP.get(storeCode);
    }

}
