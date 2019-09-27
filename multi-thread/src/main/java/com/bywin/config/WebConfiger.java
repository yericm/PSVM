package com.bywin.config;

import com.bywin.interceptor.BywinInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by yeric on 2019/9/27
 */
@Configuration
public class WebConfiger implements WebMvcConfigurer {
    @Autowired
    private BywinInterceptor bywinInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，排除 downloadTxt
        registry.addInterceptor(bywinInterceptor).addPathPatterns("/findAll")
                .excludePathPatterns("/downloadTxt");
    }
}
