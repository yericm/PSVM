package com.bywin.base.sort;

import com.alibaba.fastjson.JSONArray;
import com.bywin.dto.KefuDTO;
import com.bywin.dto.KefuSeatDTO;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yeric
 * @date 2020/8/25 20:25
 */
public class TestDemo {
    public void sout () {
        Class<? extends TestDemo> aClass = this.getClass();
        System.out.println(aClass);
        System.out.println(TestDemo.class);
    }
    public static void main(String[] args) throws InterruptedException {
        TestDemo testDemo = new TestDemo();
        testDemo.sout();
    }
}
