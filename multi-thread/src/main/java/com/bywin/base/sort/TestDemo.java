package com.bywin.base.sort;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author yeric
 * @date 2020/8/25 20:25
 */
public class TestDemo {
    public static void main(String[] args) {
        int APPLY_TYPE_TOPIC = 6;
        System.out.println(6!=APPLY_TYPE_TOPIC);
        System.out.println(!String.valueOf(6).equals(String.valueOf(APPLY_TYPE_TOPIC)));
        System.out.println(6 == 6);
        System.out.println(7 == 6);

        System.out.println(6!=6);
//        String s = DigestUtils.md5DigestAsHex("password.getBytes()".getBytes());
//        System.out.println(s);
    }
}
