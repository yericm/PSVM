package com.bywin.design_patterns.chapater4.factory_pattern;

/**
 * created by yeric on 2019/8/13
 */
public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
