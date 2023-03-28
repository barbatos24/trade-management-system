package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

/**
 * @author： zhoudewei
 * @date： 2023/3/28 11:25
 * @version： v1.0
 */
@Getter
public enum IsDelEnum {
    YES(1, "已删除"),
    NO(0, "未删除"),
    ;

    private Integer code;
    private String desc;

    IsDelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
