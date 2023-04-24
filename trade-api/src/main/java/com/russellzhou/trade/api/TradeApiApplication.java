package com.russellzhou.trade.api;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author： zhoudewei
 * @date： 2023/3/27 17:30
 * @description：
 * @version： v1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {" com.russellzhou.trade.data.mapper"})
@ComponentScan(value = "com.russellzhou")
@EnableScheduling
public class TradeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeApiApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
