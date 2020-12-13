package com.bywin.base.sort;

import org.apache.commons.math3.random.RandomDataGenerator;


/**
 * // TODO: 2020/11/15 优化成多线程的，现在跑完这个程序最快也要五分钟+
 *
 * @author yeric
 * @date 2020/11/8 22:59
 */
public class YiMao {
    public static void main(String[] args) {
        int num = 100;
        for (int j = 1; j <= num; j++) {
            int money = new RandomDataGenerator().nextInt(1000, 9999);
            System.out.println(money);
        }
    }
}
