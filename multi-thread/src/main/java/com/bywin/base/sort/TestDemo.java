package com.bywin.base.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bywin.dto.KefuDTO;
import com.bywin.dto.KefuSeatDTO;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
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
        Date date = DateUtils.addMinutes(new Date(), 5);
        String strDate = DateFormatUtils.format(date, "HH:mm");
        System.out.println(strDate);
    }

    public static boolean isOu(int item) {
        return item % 2 == 0;
    }
}
