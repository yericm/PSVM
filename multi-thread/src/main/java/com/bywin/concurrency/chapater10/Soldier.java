package com.bywin.concurrency.chapater10;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * created by yeric on 2019/7/16
 */
public class Soldier implements Runnable {
    private String soldier;
    private final CyclicBarrier cyclic;

    public Soldier(String soldier, CyclicBarrier cyclic) {
        this.soldier = soldier;
        this.cyclic = cyclic;
    }

    @Override
    public void run() {
        try {
            // 等待所有士兵到齐
            cyclic.await();
            doWork();
            // 等待所有士兵完成工作
            cyclic.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void doWork () {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(soldier + "：任务完成");
    }
}
