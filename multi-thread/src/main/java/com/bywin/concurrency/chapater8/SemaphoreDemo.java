package com.bywin.concurrency.chapater8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量可以指定多个线程，同时访问某一个资源，
 * 扩展了synchronized和ReentrantLock锁
 * 一次只允许一个线程访问同一个资源的局限
 * created by yeric on 2019/7/15 22:23
 */
public class SemaphoreDemo implements Runnable {
    // 声明一个包含5个许可的信号量
    final Semaphore semp = new Semaphore(5);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        SemaphoreDemo semapDemo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(semapDemo);
        }
    }
    @Override
    public void run() {
        try {
            // 限制执行这段代码的线程数
            semp.acquire();
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getId() + ":donw!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
