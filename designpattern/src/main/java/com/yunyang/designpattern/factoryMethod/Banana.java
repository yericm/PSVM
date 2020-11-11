package com.yunyang.designpattern.factoryMethod;

/**
 * @author yeric
 * @date 2020/11/11 08:30
 */
public class Banana implements Fruit {
    @Override
    public void price() {
        System.out.println("香蕉两块一斤");
    }

    @Override
    public void taste() {
        System.out.println("香蕉是甜的");
    }
}
