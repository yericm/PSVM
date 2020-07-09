package com.yunyang.muke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * created by yeric on 2019/7/30
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages="com.yunyang.muke.dao")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.yunyang"})
public class WeChatPractice {
    public static void main(String[] args) {
        SpringApplication.run(WeChatPractice.class, args);
    }
}
