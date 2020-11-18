package com.yunyang.designpattern.decorator;


/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:23
 */
public class ZhenZhuMilkTea implements MilkTea {
    @Override
    public String description() {
        return "珍珠奶茶";
    }

    @Override
    public int cost() {
        return 9;
    }
}
