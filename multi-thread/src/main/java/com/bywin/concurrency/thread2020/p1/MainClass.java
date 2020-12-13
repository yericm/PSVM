package com.bywin.concurrency.thread2020.p1;

/**
 * @author yeric
 * @description:
 * @date 2020/12/10 07:56
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("main线程开始执行");
        Thread thread1 = new Thread(new MyRunAble(),"线程一");
        thread1.start();

        Thread thread2 = new Thread(new MyRunAble(),"线程二");
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread3 = new Thread(new MyRunAble(),"线程三");
        thread3.start();



        System.out.println("main线程结束执行了。。。。。");
    }
}
