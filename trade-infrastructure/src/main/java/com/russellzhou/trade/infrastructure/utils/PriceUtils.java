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
    public static long changeYuan2Fen(Float amount){
        return new BigDecimal(amount).multiply(new BigDecimal(100)).longValue();
    }

    /**
     * 转换分为人民币¥的形式
     * @return
     */
    public static String changeFen2ChineseYuan(Long price){
        StringBuffer sb = new StringBuffer();
        sb.append("¥").append(BigDecimal.valueOf(price).divide(new BigDecimal(100)).toString());
        return sb.toString();
    }

}
