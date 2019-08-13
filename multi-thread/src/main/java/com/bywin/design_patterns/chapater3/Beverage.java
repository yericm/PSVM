package com.bywin.design_patterns.chapater3;

/**
 * 饮料抽象类
 * created by yeric on 2019/8/13
 */
public abstract class Beverage {
    protected String description;

    public String getDescription() {
        return description;
    }

    /**
     * 获取每种饮料的价格
     * @return
     */
    public abstract double cost();
}
