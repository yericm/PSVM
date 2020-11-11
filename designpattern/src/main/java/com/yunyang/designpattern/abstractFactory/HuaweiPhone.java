package com.yunyang.designpattern.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/12 07:41
 */
public class HuaweiPhone implements Phone {
    @Override
    public void price() {
        System.out.println("华为手机，安卓系统，价格也贵了");
    }
}
