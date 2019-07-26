package com.bywin.concurrency.chapater11;

import java.util.concurrent.Phaser;

/**
 * 游泳者线程.需要持有phaser对象
 * created by yeric on 2019/7/26
 */
public class Swimmer implements Runnable {
    private Phaser phaser;

    public Swimmer(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        /*
         * 从这里到第一个phaser.arriveAndAwaitAdvance()是第一阶段做的事
         */
        System.out.println("游泳选手-" + Thread.currentThread().getName() + ":已到达赛场");

        phaser.arriveAndAwaitAdvance();

        /*
         * 从这里到第二个phaser.arriveAndAwaitAdvance()是第二阶段做的事
         */
        System.out.println("游泳选手-" + Thread.currentThread().getName() + ":已准备好");
        phaser.arriveAndAwaitAdvance();

        /*
         * 从这里到第三个phaser.arriveAndAwaitAdvance()是第三阶段做的事
         */
        System.out.println("游泳选手-" + Thread.currentThread().getName() + ":完成比赛");

        phaser.arriveAndAwaitAdvance();

    }
}
