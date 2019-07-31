package com.bywin.design_patterns.chapater2;

/**
 * created by yeric on 2019/7/31
 */
public class MainClass {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        User user1 = new User("张三");
        User user2 = new User("李四");
        User user3 = new User("张三");
        server.registerObserver(user1);
        server.registerObserver(user2);
        server.registerObserver(user3);
        server.setInfomation("一惊一乍");
    }
}
