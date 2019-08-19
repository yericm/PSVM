package com.bywin.design_patterns.chapater12;

/**
 * created by yeric on 2019/8/19
 */
public interface State {
    void insertCoin();
    void returnCoin();
    void turnCrank();
    void dispense();
    void printstate();
}
