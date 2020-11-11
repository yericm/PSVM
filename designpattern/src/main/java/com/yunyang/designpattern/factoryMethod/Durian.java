package com.yunyang.designpattern.factoryMethod;

/**
 * @author yeric
 * @date 2020/11/11 08:32
 */
public class Durian implements Fruit {
    @Override
    public void price() {
        System.out.println("榴莲19块一斤");
    }

    @Override
    public void taste() {
        System.out.println("榴莲是丑的");
    }
}
