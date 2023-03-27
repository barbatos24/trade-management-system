package com.russellzhou.trade.infrastructure.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author： zhoudewei
 * @date： 2023/3/24 11:52
 * @description： 爬虫任务的操作类型
 * @version： v1.0
 */
@Getter
public enum SpiderOperateTypeEnum {
    JOB(1, "定时任务脚本"),
    MANUAL(2, "人工手动执行")
    ;


    private Integer type;

    private String desc;

    SpiderOperateTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    static Map<Integer, SpiderOperateTypeEnum> ENUM_MAP = new HashMap<>();

    static {
        Stream.of(SpiderOperateTypeEnum.values()).forEach(obj -> {
            ENUM_MAP.put(obj.type, obj);
        });
    }

    public static SpiderOperateTypeEnum get(Integer type){
        return type == null ? null : ENUM_MAP.get(type);
    }


}
