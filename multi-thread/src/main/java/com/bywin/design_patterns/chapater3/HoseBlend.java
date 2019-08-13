package com.bywin.design_patterns.chapater3;

/**
 * 黑咖啡（饮料）
 * created by yeric on 2019/8/13
 */
public class HoseBlend extends Beverage {
    public HoseBlend() {
        description = "HoseBlend";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
