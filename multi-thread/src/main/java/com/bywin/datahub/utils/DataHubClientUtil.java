package com.bywin.datahub.utils;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.DatahubClientBuilder;
import com.aliyun.datahub.client.auth.AliyunAccount;
import com.aliyun.datahub.client.common.DatahubConfig;
import com.aliyun.datahub.client.http.HttpConfig;

/**
 * created by yeric on 2020/3/3
 */
public class DataHubClientUtil {

    public static DatahubClient getDataHubClient() {
        // Endpoint以Region: 华东1为例，其他Region请按实际情况填写
        String endpoint = "http://dh-cn-hangzhou.aliyuncs.com";
        String accessId = "LTAI4Fj1LQkafMGUYrFMudqz";
        String accessKey = "noPFbXfoT5JfZauIbVIRJdzaDGY1Ho";
        // 创建DataHubClient实例
        return DatahubClientBuilder.newBuilder()
                .setDatahubConfig(
                        new DatahubConfig(endpoint,
                                // 是否开启二进制传输，服务端2.12版本开始支持
                                new AliyunAccount(accessId, accessKey), true))
                //专有云使用出错尝试将参数设置为       false
                // HttpConfig可不设置，不设置时采用默认值
                .setHttpConfig(new HttpConfig().setConnTimeout(10000))
                .build();
    }
}
