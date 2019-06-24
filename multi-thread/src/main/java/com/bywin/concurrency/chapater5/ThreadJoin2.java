package com.bywin.concurrency.chapater5;


import java.util.stream.IntStream;

/**
 * created by yeric on 2019/6/24 22:18
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            IntStream.range(1, 1000).forEach(i -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + i );
            });
        });
        thread.start();
        // 等待10秒你还没执行完就不等了，先执行自己的
        thread.join(10000);
        System.out.println("thread执行完成了");
        IntStream.range(1, 1000).forEach(i -> {
            System.out.println(Thread.currentThread().getName() + i);
        });
    }
}
