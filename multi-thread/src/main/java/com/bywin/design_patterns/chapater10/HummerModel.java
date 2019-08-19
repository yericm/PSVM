package com.bywin.design_patterns.chapater10;

/**
 * created by yeric on 2019/8/16
 */
public abstract class HummerModel {
    protected abstract void start(); //发动

    protected abstract void stop();  //停止

    protected abstract void alarm(); //鸣笛

    protected abstract void engineBoom(); //轰鸣

    final public void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     * 钩子方法
     * @return
     */
    protected boolean isAlarm() { //我们加了一个判断方法，默认返回true
        return true;
    }
}
