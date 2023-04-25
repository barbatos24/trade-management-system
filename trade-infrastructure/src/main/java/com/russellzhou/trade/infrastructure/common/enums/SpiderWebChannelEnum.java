package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author： zhoudewei
 * @date： 2023/3/27 11:16
 * @description： 爬虫的数据来源
 * @version： v1.0
 */
@Getter
public enum SpiderWebChannelEnum {
    WECHAT_MINI_PROGRAMMER(1000, "WECHAT_MINI_PROGRAMMER", "微信小程序")
    ;

    private Integer code;

    private String type;

    private String desc;

    SpiderWebChannelEnum(Integer code, String type, String desc) {
        this.code = code;
        this.type = type;
        this.desc = desc;
    }

    public static Map<Integer, SpiderWebChannelEnum> ENUM_MAP = new HashMap<>();

    static {
        Stream.of(SpiderWebChannelEnum.values()).forEach(obj -> {
            ENUM_MAP.put(obj.code, obj);
        });
    }

    public static SpiderWebChannelEnum get(Integer code){
        return code == null ? null : ENUM_MAP.get(code);
    }

}
