package com.bywin.design_patterns.chapater11;

/**
 * 策略模式
 * 策略模式的一系列算法是可以相互替换的、是平等的，写在一起就是if-else组织结构，
 * 如果算法实现里又有条件语句，就构成了多重条件语句，可以用策略模式，避免这样的多重条件语句。
 * created by yeric on 2019/8/19
 */
public class MainClass {
    public static void main(String[] args) {
        PayContext context = new PayContext("张三", 8000, new RmbPay());
        context.pay();
        System.out.println("__________________________");
        //准备Jack的支付上下文
        PayContext ctx = new PayContext("jack",1000,new DollarPay());
        //向Jack支付工资
        ctx.pay();
    }
}
