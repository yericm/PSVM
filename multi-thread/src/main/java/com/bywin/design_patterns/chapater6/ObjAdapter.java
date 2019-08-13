package com.bywin.design_patterns.chapater6;

/**
 * 对象适配器
 * created by yeric on 2019/8/13
 */
public class ObjAdapter implements Target{
    private Adaptee adaptee;

    public ObjAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method1() {
        adaptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("对象适配器新加的方法：method 2");
    }
}
