package com.russellzhou.trade.api.interfaces;

import com.russellzhou.trade.api.assembler.SpiderApiAssembler;
import com.russellzhou.trade.api.request.BaiLianCommodityInfoRequest;
import com.russellzhou.trade.infrastructure.utils.ResponseVO;
import com.russellzhou.trade.service.impl.spider.SpiderService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author： zhoudewei
 * @date： 2023/2/21 13:57
 * @description： 爬虫相关的api
 * @version： v1.0
 */
@RestController
@RequestMapping(value = "/spiderApi")
public class SpiderApi {

    private static final Logger log = LoggerFactory.getLogger(SpiderApi.class);

    @Resource
    private SpiderService spiderService;

    @PostMapping(value = "/crawlBaiLianCommodityInfo")
    public ResponseVO<Void> crawlBaiLianCommodityInfo(@RequestBody BaiLianCommodityInfoRequest request){
        spiderService.crawlBaiLianCommodityInfo(SpiderApiAssembler.convert2GetBaiLianCommodityDto(request));
        return new ResponseVO(200, "Success", null);
    }

}
