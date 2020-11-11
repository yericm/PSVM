package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:43
 */
public class ApplePhone implements Phone {
    @Override
    public void price() {
        System.out.println("苹果手机，ios系统，价格上万了");
    }
}
