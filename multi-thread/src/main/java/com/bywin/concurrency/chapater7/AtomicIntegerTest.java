package com.bywin.concurrency.chapater7;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger提供原子操作来进行Integer的使用
 * 原子类的增强->LongAdder;LongAdder的增强版：LongAccumulator
 * created by yeric on 2019/7/5
 */
public class AtomicIntegerTest {
    private static final int THREADS_CONUT = 20;
//    public static volatile int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
//        count++;
        count.incrementAndGet();
    }

    /**
     * 需要使用debug模式启动
     * @param args
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }
}
