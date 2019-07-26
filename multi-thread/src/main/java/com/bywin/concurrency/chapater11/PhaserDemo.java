package com.bywin.concurrency.chapater11;

/**
 * 博客地址：https://www.jianshu.com/p/ce81b6736e01
 * created by yeric on 2019/7/26
 */
public class PhaserDemo {

    //游泳选手个数
    private static int swimmerNum = 6;

    public static void main(String[] args) {

        MyPhaser phaser = new MyPhaser();

        //注册主线程,用于控制phaser何时开始第二阶段
        phaser.register();
        for (int i = 0; i < swimmerNum; i++) {
            phaser.register();
            new Thread(new Swimmer(phaser), "swimmer" + i).start();
        }
        /*
         * 此时某个游泳者所在的线程都已经完成了第一阶段,但是没法进入第二阶段,因为主线程还没到达第一阶段
         */
        //主线程到达第一阶段并且不参与后续阶段.其它线程从此时可以进入后面的阶段.
        phaser.arriveAndDeregister();
        //加while是为了防止其它线程没结束就打印了"比赛结束”
        while (!phaser.isTerminated()) {

        }
        System.out.println("===== 比赛结束 =====");
    }
}
