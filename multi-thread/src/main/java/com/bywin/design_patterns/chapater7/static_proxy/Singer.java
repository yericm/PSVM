package com.bywin.design_patterns.chapater7.static_proxy;

/**
 * created by yeric on 2019/8/14
 */
public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("在唱歌");
    }
}
