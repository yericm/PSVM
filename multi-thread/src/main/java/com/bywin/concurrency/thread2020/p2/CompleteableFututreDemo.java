package com.bywin.concurrency.thread2020.p2;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiConsumer;

/**
 * @author yeric
 * @description:
 * @date 2021/1/4 07:28
 */
@Slf4j
public class CompleteableFututreDemo {
    private volatile  int a = 1;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a =1;
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("异步线程执行完成");
//        });
//        System.out.println(future.get()); // 该方法会阻塞
//        System.out.println("主线程结束");
//        System.out.println("****************");
//        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("异步线程执行完成");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return System.currentTimeMillis();
//        });
//        System.out.println(future.get()); // 会阻塞
//        System.out.println("主线程执行完成");
//        CompletableFuture<Object> future = new CompletableFuture<>();
//        future.complete("手动执行完成future");
//        Object o = future.get();
//        System.out.println(o);
        System.out.println(-1 << 29);
        System.out.println( 0 << 29);
        System.out.println( 1 << 29);
        System.out.println( 2 << 29);
        System.out.println( 3 << 29);
    }
}
