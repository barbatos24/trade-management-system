package com.russellzhou.trade.api.backend;

import com.russellzhou.trade.infrastructure.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zhoudewei
 * @date： 2023/2/21 13:57
 * @description： 爬虫相关的api
 * @version： v1.0
 */
@RestController
@RequestMapping(value = "/spiderRelated")
public class SpiderRelatedApi {

    @PostMapping(value = "/getSpiderInfo")
    public Result<Void> getSpiderInfo(){
        return null;
    }

}
