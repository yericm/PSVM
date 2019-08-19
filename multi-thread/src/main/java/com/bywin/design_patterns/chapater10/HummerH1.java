package com.bywin.design_patterns.chapater10;

/**
 * created by yeric on 2019/8/16
 */
public class HummerH1 extends HummerModel {

    @Override
    protected void start() {
        System.out.println("H1发动……");
    }

    @Override
    protected void stop() {
        System.out.println("H1停止……");
    }

    @Override
    protected void alarm() {
        System.out.println("H1鸣笛……");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H1轰鸣……");
    }
}
