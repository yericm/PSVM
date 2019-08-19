package com.bywin.design_patterns.chapater11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by yeric on 2019/8/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayContext {
    private String name;
    private double salary;
    private PayStrategy payStrategy;

    public void pay(){
        //调用具体的支付策略来进行支付
        payStrategy.pay(this);
    }
}
