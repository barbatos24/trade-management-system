package com.russellzhou.trade.api.assembler.dto;

import com.russellzhou.trade.api.interfaces.request.BaiLianCommodityInfoRequest;
import com.russellzhou.trade.api.service.dto.spider.GetBaiLianCommodityDto;
import com.russellzhou.trade.infrastructure.common.enums.BaiLianShopEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author： zhoudewei
 * @date： 2023/3/23 11:19
 * @description：SpiderApi 参数转换
 * @version： v1.0
 */
public class SpiderApiAssembler {

    public static GetBaiLianCommodityDto convert2GetBaiLianCommodityDto(BaiLianCommodityInfoRequest request){
        GetBaiLianCommodityDto commodityDto = new GetBaiLianCommodityDto();
        if(StringUtils.isEmpty(request.getShopCode())){
            commodityDto.setShopCode(BaiLianShopEnum.ALL_BAI_LIAN_SHOP_CODE);
        }else{
            commodityDto.setShopCode(Arrays.asList(request.getShopCode()));
        }
        commodityDto.setOperateType(request.getOperateType());
        commodityDto.setUserName(request.getUserName());
        return commodityDto;
    }
}
