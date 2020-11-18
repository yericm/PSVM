package com.yunyang.designpattern.decorator;


/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:28
 */
public class ZhenZhuDecorator extends Decorator {

    public ZhenZhuDecorator(MilkTea milkTea) {
        this.milkTea = milkTea;
    }
    @Override
    public String description() {
        return milkTea.description() + "珍珠";
    }

    @Override
    public int cost() {
        return milkTea.cost()+2;
    }
}
