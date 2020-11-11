package com.yunyang.designpattern.factoryMethod;

/**
 * @author yeric
 * @date 2020/11/11 08:31
 */
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Banana();
    }
}
