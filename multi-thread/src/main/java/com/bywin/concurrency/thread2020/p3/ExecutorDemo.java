package com.bywin.concurrency.thread2020.p3;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author yeric
 * @description:
 * @date 2021/1/6 19:37
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        IntStream.range(0,49).forEach(item->{
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " " + item);
            });
        });
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        long startTime1 = System.currentTimeMillis();
        IntStream.range(0,49).forEach(item->{
                System.out.println(Thread.currentThread().getName() + " " + item);
        });
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1-startTime1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
    }

}
