package com.bywin.design_patterns.chapater6;

/**
 * 类适配器
 * created by yeric on 2019/8/13
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void method2() {
        System.out.println("类适配器新加的方法：method 2");
    }
}
