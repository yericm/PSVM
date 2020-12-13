package com.bywin.base.sort;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
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
        LocalDate onLineDate = LocalDate.of(2019, 10, 1);
        LocalDate yesterday = LocalDate.now().minusDays(1);
        System.out.println(yesterday.toEpochDay() - onLineDate.toEpochDay());
    }
}
