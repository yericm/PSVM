package com.bywin.concurrency.chapater9;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计数器
 * created by yeric on 2019/7/16
 */
public class CountDownLatchDemo implements Runnable{
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatchDemo demo = new CountDownLatchDemo();
        for (int i = 0; i < 10; i++) {
            pool.submit(demo);
        }
        // 等待其它检查完成
        countDownLatch.await();
        System.out.println("都检查完了，可以发射了");
        pool.shutdown();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount());
        }
    }
}
