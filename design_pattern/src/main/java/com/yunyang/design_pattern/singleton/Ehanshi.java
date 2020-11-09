package com.yunyang.design_pattern.singleton;

/**
 * @author yeric
 * @date 2020/11/8 22:25
 */
public class Ehanshi {
    public static final Ehanshi instance = new Ehanshi();
    private Ehanshi () {

    }
    public static Ehanshi getInstance () {
        return instance;
    }

    public static void main(String[] args) {
        Ehanshi instance = Ehanshi.getInstance();
        Ehanshi instance1 = Ehanshi.getInstance();
        System.out.println(instance==instance1);
    }
}
