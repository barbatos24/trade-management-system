package com.russellzhou.trade.infrastructure.utils;

import java.math.BigDecimal;

/**
 * @author： zhoudewei
 * @date： 2023/3/26 21:33
 * @description： 金额的处理
 * @version： v1.0
 */
public class PriceUtils {

    /**
     * 转换元为分
     * @param amount
     * @return
     */
    public static BigDecimal changeYuan2Fen(Float amount){
        return new BigDecimal(amount).multiply(new BigDecimal(100));
    }

}
