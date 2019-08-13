package com.bywin.design_patterns.chapater6.head_first_demo;

/**
 * 野生火鸡
 * created by yeric on 2019/8/13
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble gobble!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance!");
    }
}
