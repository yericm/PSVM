package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:44
 */
public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory = new HuaweiFactory(); // 华为工厂
        AbstractFactory factory = new AppleFactory(); // 苹果工厂
        factory.createPhone().price();
        factory.createComputer().price();

    }
}
