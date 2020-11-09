package com.bywin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * created by yeric on 2019/7/30
 */
@SpringBootApplication
@EnableCaching
public class BywinPractice {
    public static void main(String[] args) {
        SpringApplication.run(BywinPractice.class, args);
    }

    @Bean
    public RestTemplate sa () {
        return new RestTemplate();
    }
}
