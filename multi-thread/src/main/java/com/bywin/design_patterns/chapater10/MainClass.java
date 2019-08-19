package com.bywin.design_patterns.chapater10;

/**
 * 模板方法模式
 * created by yeric on 2019/8/16
 */
public class MainClass {
    public static void main(String[] args) {
        HummerH1 hummerH1 = new HummerH1();
        hummerH1.run();
        System.out.println("------------------------------------------------");
        HummerH2 hummerH2 = new HummerH2();
        hummerH2.setAlarmFlag(false);
        hummerH2.run();
    }
}
