package com.bywin.design_patterns.chapater11;

/**
 * created by yeric on 2019/8/19
 */
public class RmbPay implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        System.out.println("人民币方式支付"+payContext.getName() + payContext.getSalary() + "元");
    }
}
