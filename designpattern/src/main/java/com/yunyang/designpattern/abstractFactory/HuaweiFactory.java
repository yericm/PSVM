package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:40
 */
public class HuaweiFactory implements  AbstractFactory{
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }
}
