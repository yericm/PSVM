package com.bywin.design_patterns.chapater6.head_first_demo;

/**
 * 博客地址：https://segmentfault.com/a/1190000016638266
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        // 将火鸡包装进一个火鸡适配器中，使它看起来像一只鸭子
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

        System.out.println("\nThe TurkeyAdapter says ...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
