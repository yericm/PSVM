package com.bywin.design_patterns.chapater4.abstract_factory_pattern;

/**
 * 抽象工厂 博客地址：https://www.cnblogs.com/JuanF/p/9275833.html
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        DellFactory dellFactory = new DellFactory();
        dellFactory.createMouse().sayHi();
        dellFactory.createKeyBoard().kick();
        HpFactory hpFactory = new HpFactory();
        hpFactory.createKeyBoard().kick();
        hpFactory.createMouse().sayHi();
    }
}
