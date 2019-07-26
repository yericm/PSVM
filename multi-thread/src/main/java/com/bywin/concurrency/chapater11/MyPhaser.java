package com.bywin.concurrency.chapater11;

import java.util.concurrent.Phaser;

/**
 * 自定义Phaser类,需要重写onAdvance方法
 * created by yeric on 2019/7/26
 */
public class MyPhaser extends Phaser {

    // 定义结束阶段.这里是完成3个阶段以后结束
    private int phaseToTerminate = 2;

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {

        System.out.println("*第" + phase + "阶段完成*");

        // 到达结束阶段,或者还没到结束阶段但是party为0,都返回true,结束phaser
        return phase == phaseToTerminate || registeredParties == 0;

    }
}
