package com.bywin.concurrency.chapater10;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 * created by yeric on 2019/7/16
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final int N = 10;
        boolean flag = false;
        Thread[] allSoldier = new Thread[10];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍");
        for (int i = 0; i < N; ++i) {
            System.out.println("士兵" + i + "报道！");
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoldier[i].start();
        }
    }
}
