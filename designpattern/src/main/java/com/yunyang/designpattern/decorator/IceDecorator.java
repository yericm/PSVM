package com.yunyang.designpattern.decorator;

/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:27
 */
public class IceDecorator extends Decorator {

    public IceDecorator(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String description() {
        return milkTea.description()+"冰块";
    }

    @Override
    public int cost() {
        return milkTea.cost()+1;
    }
}
