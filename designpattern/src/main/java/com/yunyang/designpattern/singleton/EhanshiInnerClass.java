package com.yunyang.designpattern.singleton;

/**
 * 饿汉式 内部类方式
 *
 * @author yeric
 * @date 2020/11/8 22:31
 */
public class EhanshiInnerClass {
    public EhanshiInnerClass() {

    }

    public static class InnerClass {
        private final static EhanshiInnerClass instance = new EhanshiInnerClass();
    }

    public static EhanshiInnerClass getInstance() {
        return InnerClass.instance;
    }

    public static void main(String[] args) {
        EhanshiInnerClass instance = EhanshiInnerClass.getInstance();
        EhanshiInnerClass instance1 = EhanshiInnerClass.getInstance();
        System.out.println(instance == instance1);
    }
}
