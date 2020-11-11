package com.yunyang.designpattern.factoryMethod;

/**
 * @author yeric
 * @date 2020/11/11 08:33
 */
public class DurianFactory implements FruitFactory {
    @Override
    public Fruit create() {
        return new Durian();
    }
}
