package com.bywin.design_patterns.chapater6;

/**
 * 适配器模式 博客地址：https://blog.csdn.net/mrkohaku/article/details/79087688
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
        System.out.println("************************************************");
        ObjAdapter objAdapter = new ObjAdapter(new Adaptee());
        objAdapter.method1();
        objAdapter.method2();
    }
}
