package com.bywin.design_patterns.chapater11;

/**
 * created by yeric on 2019/8/19
 */
public class DollarPay implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        System.out.println("美元方式支付给"+payContext.getName() + payContext.getSalary() + "美金");
    }
}
