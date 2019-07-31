package com.bywin.design_patterns.chapater2;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义被观察者
 * created by yeric on 2019/7/31
 */
public class WechatServer implements Subject {
    private List<Observer> observers;
    private String message;

    public WechatServer() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i > 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String message) {
        this.message = message;
        System.out.println("微信服务更新消息： " + message);
        //消息更新，通知所有观察者
        notifyObservers();
    }
}
