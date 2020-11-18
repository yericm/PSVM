package com.yunyang.designpattern.decorator;


/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:25
 */
public abstract class Decorator implements MilkTea{

    public MilkTea milkTea;
    @Override
    public abstract String description();
    @Override
    public abstract int cost();
}
