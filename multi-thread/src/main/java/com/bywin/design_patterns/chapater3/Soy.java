package com.bywin.design_patterns.chapater3;

/**
 * 调料（豆浆）
 * created by yeric on 2019/8/13
 */
public class Soy extends Condiment{
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.23 + beverage.cost();
    }
}
