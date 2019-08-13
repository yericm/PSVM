package com.bywin.design_patterns.chapater4.abstract_factory_pattern;

/**
 * created by yeric on 2019/8/13
 */
public class HpFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyBoard();
    }
}
