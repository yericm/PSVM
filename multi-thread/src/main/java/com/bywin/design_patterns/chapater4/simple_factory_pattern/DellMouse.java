package com.bywin.design_patterns.chapater4.simple_factory_pattern;

/**
 * 鼠标扩展类
 * created by yeric on 2019/8/13
 */
class DellMouse extends Mouse{
    @Override
    public void sayHi() {
        System.out.println("产品：戴尔鼠标");
    }
}
