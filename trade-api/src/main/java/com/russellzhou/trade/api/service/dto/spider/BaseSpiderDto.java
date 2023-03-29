package com.russellzhou.trade.api.service.dto.spider;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 14:34
 * @description： 爬虫内部对象基础类
 * @version： v1.0
 */
@Setter
@Getter
public class BaseSpiderDto {

    /**
     * 操作类型
     */
    private Integer operateType;

    /**
     * 操作人
     */
    private String userName;

}
