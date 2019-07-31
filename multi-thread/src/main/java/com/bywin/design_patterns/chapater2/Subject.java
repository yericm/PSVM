package com.bywin.design_patterns.chapater2;

/**
 * 被观察的主题接口
 * created by yeric on 2019/7/31
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
