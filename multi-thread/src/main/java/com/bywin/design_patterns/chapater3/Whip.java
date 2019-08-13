package com.bywin.design_patterns.chapater3;

/**
 * 调料（奶泡）
 * created by yeric on 2019/8/13
 */
public class Whip extends Condiment{
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.69 + beverage.cost();
    }
}
