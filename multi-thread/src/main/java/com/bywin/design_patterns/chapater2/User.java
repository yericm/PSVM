package com.bywin.design_patterns.chapater2;

/**
 * created by yeric on 2019/7/31
 */
public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到推送消息：" + message);
    }
}
