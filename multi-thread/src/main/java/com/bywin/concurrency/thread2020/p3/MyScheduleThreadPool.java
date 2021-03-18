package com.bywin.concurrency.thread2020.p3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/1/6 20:32
 */
public class MyScheduleThreadPool {
    public static void main(String[] args) {
        {
            ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
            Runnable runnable1 = new Runnable()  {
                @Override
                public void run()
                {
                    String currentTime = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date());
                    System.out.println("Runnable-1 currentTime=" + currentTime);
                }
            };
            //延时3秒后执行
            scheduledThreadPool.schedule(runnable1, 3, TimeUnit.SECONDS);

            Runnable runnable2 = new Runnable()  {
                @Override
                public void run()
                {
                    String currentTime = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date());
                    System.out.println("Runnable-2 currentTime=" + currentTime);
                }
            };
            //开始延时1秒后执行, 然后每隔3秒执行一次
            scheduledThreadPool.scheduleAtFixedRate(runnable2, 1, 3, TimeUnit.SECONDS);
        }
    }
}
