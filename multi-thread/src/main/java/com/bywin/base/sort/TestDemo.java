package com.bywin.base.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bywin.dto.KefuDTO;
import com.bywin.dto.KefuSeatDTO;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.text.StringEscapeUtils;
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
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yeric
 * @date 2020/8/25 20:25
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
//        long count = IntStream.range(1, 200000).filter(TestDemo::isOu).count();
        long count = IntStream.range(1, 200000).parallel().filter(TestDemo::isOu).count();
//        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static boolean isOu(int item) {
        return item % 2 == 0;
    }
}
