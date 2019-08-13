package com.bywin.design_patterns.chapater3;

/**
 * 装饰者设计模式
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ", $" + beverage.cost());
        Beverage beverage2 = new HoseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + ", $" + beverage2.cost());
        Beverage beverage3 = new DarkRoast();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + ", $" + beverage3.cost());
    }
}
