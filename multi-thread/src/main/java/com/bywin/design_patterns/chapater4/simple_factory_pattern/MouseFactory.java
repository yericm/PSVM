package com.bywin.design_patterns.chapater4.simple_factory_pattern;

/**
 * created by yeric on 2019/8/13
 */
public class MouseFactory {
    //生产鼠标的方法，所有的鼠标都通过该方法生成
    public static Mouse createMouse(int i) {
        switch (i) {
            case 0:
                return new DellMouse();
            case 1:
                return new HpMouse();
            default:
                return null;
        }
    }
}
