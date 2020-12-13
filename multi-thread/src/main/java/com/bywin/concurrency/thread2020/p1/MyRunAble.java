package com.bywin.concurrency.thread2020.p1;

/**
 * @author yeric
 * @description:
 * @date 2020/12/10 07:55
 */
public class MyRunAble implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
