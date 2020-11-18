package com.bywin.base.sort;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * // TODO: 2020/11/15 优化成多线程的，现在跑完这个程序最快也要五分钟+
 * @author yeric
 * @date 2020/11/8 22:59
 */
public class QiXinCai {
    public static void main(String[] args) {
        int i = 1;
        int num = 10000;
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= num; j++) {
            while (true) {
                int money = new RandomDataGenerator().nextInt( 1000,9999);
                i++;
                if (money == 8873) {
                    System.out.println("第" + j + "次" + "需要" + i + "次");
                    list.add(i);
                    i = 0;
                    break;
                }
            }
        }
        Collections.sort(list);
        System.out.println("最少"+list.get(0)+"次");
        System.out.println("第二少"+list.get(1)+"次");
        System.out.println("第三少"+list.get(2)+"次");
        System.out.println("跑"+num+"次+，中奖8873最少需要"+list.get(0)+"次,"+"最多需要"+ list.get(num-1)+"次");
    }
}
