package com.bywin.design_patterns.chapater13;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author yeric
 * @description:
 * @date 2021/1/2 21:46
 */
public class CountDownLatchMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        IntStream.range(0,3).forEach(i->new Thread(()->{
            try {
                Thread.sleep(2000L);
                System.out.println("子线程"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }).start());
        System.out.println("第一套子线程启动完毕");
        countDownLatch.await();
        System.out.println("主线程执行完毕");
//        IntStream.range(0,3).forEach(System.out::println);
//        System.out.println("*********");
//        IntStream.rangeClosed(0, 3).forEach(System.out::println);
    }
}
