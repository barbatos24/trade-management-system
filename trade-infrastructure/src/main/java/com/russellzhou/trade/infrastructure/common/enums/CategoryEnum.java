package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

/**
 * @author： zhoudewei
 * @date： 2023/5/7 18:39
 * @description： 商品类目
 * @version： v1.0
 */
@Getter
public enum CategoryEnum{

    UNKNOWN(0, "未知"),
    SHOE(100,"鞋"),
    CLOTHING(200, "服装"),
    ACCESSORY(300,"配饰")
    ;

    private Integer code;

    private String desc;

    CategoryEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
