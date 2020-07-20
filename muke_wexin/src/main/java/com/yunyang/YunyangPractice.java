package com.yunyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * created by yeric on 2019/7/30
 */
@SpringBootApplication
@EnableCaching
public class YunyangPractice {
    public static void main(String[] args) {
        SpringApplication.run(YunyangPractice.class, args);
    }
}
