package com.yunyang.designpattern.singleton;


/**
 * @author yeric
 * @date 2020/11/8 22:40
 */
public enum SingletonEnum {
    INSTANCE;

    // 测试代码
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonEnum.INSTANCE.hashCode());
            }).start();
        }
    }
}
