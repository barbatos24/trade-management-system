package com.russellzhou.trade.api.interfaces;

import com.alibaba.fastjson.JSON;
import com.russellzhou.trade.api.assembler.dto.SpiderApiAssembler;
import com.russellzhou.trade.api.interfaces.request.BaiLianCommodityInfoRequest;
import com.russellzhou.trade.api.interfaces.request.QueryCrawledDataRequest;
import com.russellzhou.trade.api.interfaces.response.QueryCrawledDataResponse;
import com.russellzhou.trade.api.service.impl.SpiderService;
import com.russellzhou.trade.infrastructure.utils.ResponseVO;
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

    /**
     * 爬取百联云店的商品信息
     * @param request
     * @return
     */
    @PostMapping(value = "/crawlBaiLianCommodityInfo")
    public ResponseVO<Void> crawlBaiLianCommodityInfo(@RequestBody BaiLianCommodityInfoRequest request){
        log.info("开始爬取百联云店信息 crawlBaiLianCommodityInfo request:{}", JSON.toJSONString(request));
        spiderService.crawlBaiLianCommodityInfo(SpiderApiAssembler.convert2GetBaiLianCommodityDto(request));
        return ResponseVO.ofSuccess(null);
    }

    /**
     * 查询爬取到的信息
     * @return
     */
    @PostMapping(value = "/queryCrawledData")
    public ResponseVO<QueryCrawledDataResponse> queryCrawledData(@RequestBody QueryCrawledDataRequest request){
        return ResponseVO.ofSuccess(spiderService.queryCrawledData(request));
    }

}
