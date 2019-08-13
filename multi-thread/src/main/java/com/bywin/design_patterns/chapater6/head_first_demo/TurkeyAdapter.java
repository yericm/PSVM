package com.bywin.design_patterns.chapater6.head_first_demo;

/**
 * 适配器类，实现了 Duck 接口，目的将火鸡转换成鸭子，以假乱真
 * created by yeric on 2019/8/13
 */
public class TurkeyAdapter implements Duck{
    Turkey turkey;

    /**
     * 通过构造方法，获得适配对象实例化的引用
     *
     * @param turkey 适配者对象
     */
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        // 由于火鸡的飞行距离较鸭子近，为了伪装成鸭子，所以让它飞三次来对应鸭子的飞行距离
        for (int i = 0; i < 3; i++) {
            turkey.fly();
        }
    }
}
