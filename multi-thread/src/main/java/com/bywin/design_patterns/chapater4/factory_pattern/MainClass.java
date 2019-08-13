package com.bywin.design_patterns.chapater4.factory_pattern;

/**
 * 工厂模式 博客地址：https://www.cnblogs.com/JuanF/p/9275833.html
 * created by yeric on 2019/8/13
 */
public class MainClass {
    public static void main(String[] args) {
        MouseFactory hpFact = new HpMouseFactory();
        MouseFactory dellFact = new DellMouseFactory();
        Mouse hpm = hpFact.createMouse();
        Mouse dellm = dellFact.createMouse();
        hpm.sayHi();
        dellm.sayHi();
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        xiaoMiFactory.createMouse().sayHi();
    }
}
