package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:42
 */
public class HuaweiComputer implements Computer {
    @Override
    public void price() {
        System.out.println("华为电脑，价格不知道，没用过");
    }
}
