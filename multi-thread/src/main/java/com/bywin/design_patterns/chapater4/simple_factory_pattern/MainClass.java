package com.bywin.design_patterns.chapater4.simple_factory_pattern;

/**
 * 简单工厂 博客地址：https://www.cnblogs.com/JuanF/p/9275833.html
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        Mouse hpm = MouseFactory.createMouse(1);
        Mouse dellm = MouseFactory.createMouse(0);
        hpm.sayHi();
        dellm.sayHi();
    }
}
