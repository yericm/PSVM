package com.bywin.concurrency.chapater12;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created by yeric on 2019/7/25
 */
public class newFixedThreadPoolDemo {
    public static void main(String[] args) {
        Random random = new Random();
        // 创建一个大小为 3 的线程池，若任务数量大于 3 ，任务会被放在一个 LinkedBlockingQueue 里顺序执行，队列的大小为Integer.MAX_VALUE。
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 判断可是线程池可以结束
        int waitTime = 500;
        for (int i = 0; i < 10; i++) {
            String name = "线程 " + i;
            int time = random.nextInt(1000);
            waitTime += time;
            Runnable runner = new ExecutorThread(name, time);
            System.out.println("增加: " + name + " / " + time);
            System.out.println("-------------活跃的线程数：" + ((ThreadPoolExecutor) executor).getActiveCount());
            executor.execute(runner);
        }
        try {
            Thread.sleep(waitTime);
            // shutdown和awaitTermination是接口ExecutorService定义的两个方法，一般情况配合使用来关闭线程池。
            // shutdown方法：平滑的关闭ExecutorService，当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。

            // awaitTermination方法：接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
            executor.shutdown();
            System.out.println(executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS));
        } catch (InterruptedException ignored) {
        }
    }
}

class ExecutorThread implements Runnable {
    private final String name;
    private final int delay;

    public ExecutorThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("启动: " + name);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
        System.out.println("完成: " + name);
    }
}