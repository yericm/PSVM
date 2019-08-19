package com.bywin.design_patterns.chapater12;

/**
 * 状态模式 博客地址： https://www.cnblogs.com/pony1223/p/7518226.html
 * created by yeric on 2019/8/19
 */
public class MainClass {
    public static void main(String[] args) {
        CandyMachine mCandyMachine = new CandyMachine(6);

        mCandyMachine.printstate();

        mCandyMachine.insertCoin();
        mCandyMachine.printstate();

        mCandyMachine.turnCrank();

        mCandyMachine.printstate();

        mCandyMachine.insertCoin();
        mCandyMachine.printstate();

        mCandyMachine.turnCrank();

        mCandyMachine.printstate();
    }
}
