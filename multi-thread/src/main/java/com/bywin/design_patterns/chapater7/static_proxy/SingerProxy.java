package com.bywin.design_patterns.chapater7.static_proxy;

/**
 * created by yeric on 2019/8/14
 */
public class SingerProxy {
    private ISinger target;

    /**
     * 接收目标对象，以便调用sing方法
     * @param target
     */
    public SingerProxy(ISinger target) {
        this.target = target;
    }

    /**
     * 对目标对象的sing方法进行功能扩展
     */
    public void sing () {
        System.out.println("大家好");
        target.sing();
        System.out.println("谢谢大家");
    }
}
