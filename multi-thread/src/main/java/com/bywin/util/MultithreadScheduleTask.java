package com.bywin.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 多线程定时任务
 * created by yeric on 2019/9/29
 */
@Component
//@EnableScheduling
@EnableAsync
public class MultithreadScheduleTask {
    @Async
    @Scheduled(fixedDelay = 1000)  //间隔1秒
    public void tash1() {
        System.out.println("第一个定时任务开始。。。" + LocalDateTime.now());
    }

    @Async
    @Scheduled(fixedDelay = 3000)  //间隔1秒
    public void tash2() {
        System.out.println("第二个定时任务开始。。。" + LocalDateTime.now());
    }
}
