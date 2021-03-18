package com.bywin.concurrency.thread2020.p1;

import lombok.SneakyThrows;

/**
 * @author yeric
 * @description:
 * @date 2020/12/10 07:55
 */
public class MyRunAble implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        int x = 1;
        synchronized (this){
        while (x <= 30) {
            System.out.println(x++);
            Thread.sleep(1000);
        }}
    }

    public static void main(String[] args) {
        MyRunAble r = new MyRunAble();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}
