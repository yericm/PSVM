package com.bywin.design_patterns.chapater10;

/**
 * created by yeric on 2019/8/16
 */
public class HummerH2 extends HummerModel {

    private boolean alarmFlag;

    @Override
    protected void start() {
        System.out.println("H2发动……");
    }

    @Override
    protected void stop() {
        System.out.println("H2停止……");
    }

    @Override
    protected void alarm() {
        System.out.println("H2鸣笛……");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H2轰鸣……");
    }

    public void setAlarmFlag(boolean flag) {
        this.alarmFlag = flag;
    }

    /**
     * 钩子方法
     * @return
     */
    @Override
    protected boolean isAlarm() { //我们加了一个判断方法，默认返回true
        return this.alarmFlag;
    }
}
