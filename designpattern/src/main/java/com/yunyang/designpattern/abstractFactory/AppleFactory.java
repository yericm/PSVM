package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:44
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer createComputer() {
        return new AppleComputer();
    }
}
