package com.bywin.concurrency.chapater5;


import java.util.stream.IntStream;

/**
 * created by yeric on 2019/6/24 22:18
 */
public class ThreadJoin1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            IntStream.range(1, 1000).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + i );
            });
        });
        thread.start();
        thread.join();
        System.out.println("thread执行完成了");
        IntStream.range(1, 1000).forEach(i -> {
            System.out.println(Thread.currentThread().getName() + i);
        });
    }
}
