package com.bywin.design_patterns.chapater3;

/**
 * 浓缩咖啡（饮料）
 * created by yeric on 2019/8/13
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
