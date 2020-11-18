package com.yunyang.designpattern.decorator;

/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:30
 */
public class Main {
    public static void main(String[] args) {
        MilkTea order = new ZhenZhuMilkTea();
        System.out.println(order.description()+"的价格是"+order.cost());
        order = new IceDecorator(order);
        System.out.println(order.description()+"的价格是"+order.cost());
        order = new ZhenZhuDecorator(order);
        System.out.println(order.description()+"的价格是"+order.cost());
    }
}
