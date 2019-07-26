package com.bywin.concurrency.chapater12;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 博客地址：https://blog.csdn.net/zgz15515397650/article/details/79220860
 * created by yeric on 2019/7/25
 */
public class CallableAndFuture2 {
    public static void main(String[] args) {
        // 创建多线程的第三种方式
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
