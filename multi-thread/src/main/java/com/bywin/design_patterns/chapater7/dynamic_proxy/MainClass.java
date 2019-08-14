package com.bywin.design_patterns.chapater7.dynamic_proxy;



/**
 * 动态代理
 * created by yeric on 2019/8/14
 */
public class MainClass {
    public static void main(String[] args) {
        ISinger singer = new Singer();
        ISinger proxyInstance = (ISinger) new SingerProxy(singer).getSingerProxyInstance();
//        proxyInstance.sing();
        proxyInstance.singInfo("七里香", "周杰伦");
    }
}
