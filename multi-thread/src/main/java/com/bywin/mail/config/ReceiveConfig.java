package com.bywin.mail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 该配置只是为了测试@ConfigurationProperties功能
 * created by yeric on 2019/7/30
 */
@Data
@ConfigurationProperties(prefix = "to.mail")
public class ReceiveConfig {
    private String address;
}
