package com.bywin.design_patterns.chapater3;

/**
 * 调料（摩卡）
 * created by yeric on 2019/8/13
 */
public class Mocha extends Condiment{
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
