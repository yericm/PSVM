package com.bywin.concurrency.chapater7;

import java.util.concurrent.TimeUnit;

/**
 * created by yeric on 2019/7/15 21:59
 */
public class ThreadGroupName implements Runnable {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PringGroup");
        Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        // 打印这个线程组中的所有线程信息
        tg.list();
        // 所有活动线程，估计值
        System.out.println(tg.activeCount());
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
