package com.bywin.design_patterns.chapater3;

/**
 * 深焙咖啡（饮料）
 * created by yeric on 2019/8/13
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.19;
    }
}
