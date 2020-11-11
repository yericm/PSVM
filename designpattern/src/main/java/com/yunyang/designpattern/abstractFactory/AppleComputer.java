package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:43
 */
public class AppleComputer implements Computer {
    @Override
    public void price() {
        System.out.println("mac book, 价格快两万了");
    }
}
