package com.bywin.design_patterns.chapater7.static_proxy;

/**
 * 静态代理
 * created by yeric on 2019/8/14
 */
public class MainClass {
    public static void main(String[] args) {
        // 目标对象
        Singer singer = new Singer();
        // 代理对象
        SingerProxy singerProxy = new SingerProxy(singer);
        singerProxy.sing();
    }
}
