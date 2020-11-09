package com.bywin.base.sort;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yeric
 * @date 2020/8/25 20:25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SmsUtilsTest {

    @Autowired
    private SmsUtils smsUtils;

    @Test
    public void sendMsg() {
        JSONObject jsonObject = smsUtils.sendMsg("18208973297", "{\"code\":\"8765\"}");
        System.out.println(jsonObject);
    }
}