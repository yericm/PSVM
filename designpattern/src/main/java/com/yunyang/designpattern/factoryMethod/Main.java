package com.yunyang.designpattern.factoryMethod;

/**
 * @author yeric
 * @date 2020/11/11 08:34
 */
public class Main {
    public static void main(String[] args) {
        // 工厂方法把简单工厂的内部逻辑判断移动到了客户端代码来进行
        // 需要香蕉就用香蕉工厂
        FruitFactory factory = new BananaFactory();
        Fruit fruit = factory.create();
        fruit.price();
        fruit.taste();
        System.out.println("****************");
        // 需要榴莲就用榴莲工厂
        FruitFactory durianFactory = new DurianFactory();
        Fruit fruit1 = durianFactory.create();
        fruit1.taste();
        fruit1.price();
    }
}
