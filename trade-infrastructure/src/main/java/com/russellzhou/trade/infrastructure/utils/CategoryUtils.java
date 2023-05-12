package com.russellzhou.trade.infrastructure.utils;

import com.russellzhou.trade.infrastructure.common.enums.CategoryEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author： zhoudewei
 * @date： 2023/5/12 17:29
 * @description： 商品类目识别工具类
 * @version： v1.0
 */
public class CategoryUtils {

    private static final List<String> SHOE_KEY_WORD_LIST = new ArrayList<>();
    private static final List<String> CLOTHING_KEY_WORD_LIST = new ArrayList<>();
    private static final List<String> ACCESSORY_KEY_WORD_LIST = new ArrayList<>();

    static {

        SHOE_KEY_WORD_LIST.add("鞋");
        SHOE_KEY_WORD_LIST.add("靴");

        CLOTHING_KEY_WORD_LIST.add("短袖");
        CLOTHING_KEY_WORD_LIST.add("长袖");
        CLOTHING_KEY_WORD_LIST.add("T恤");
        CLOTHING_KEY_WORD_LIST.add("卫衣");
        CLOTHING_KEY_WORD_LIST.add("夹克");
        CLOTHING_KEY_WORD_LIST.add("马甲");
        CLOTHING_KEY_WORD_LIST.add("外套");
        CLOTHING_KEY_WORD_LIST.add("裤");
        CLOTHING_KEY_WORD_LIST.add("裙");

        ACCESSORY_KEY_WORD_LIST.add("包");
        ACCESSORY_KEY_WORD_LIST.add("帽");
        ACCESSORY_KEY_WORD_LIST.add("袜");

    }

    /**
     * 根据商品名称识别类目
     * @param title
     * @return
     */
    public static CategoryEnum classifyByProductTitle(String title){
        if(Objects.isNull(title)){
            return null;
        }
        if(SHOE_KEY_WORD_LIST.stream().anyMatch(item -> title.contains(item))){
            return CategoryEnum.SHOE;
        } else if (CLOTHING_KEY_WORD_LIST.stream().anyMatch(item -> title.contains(item))){
            return CategoryEnum.CLOTHING;
        } else if (ACCESSORY_KEY_WORD_LIST.stream().anyMatch(item -> title.contains(item))){
            return CategoryEnum.ACCESSORY;
        } else {
            return CategoryEnum.UNKNOWN;
        }
    }


}
