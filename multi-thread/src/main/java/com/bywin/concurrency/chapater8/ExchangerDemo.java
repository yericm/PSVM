package com.bywin.concurrency.chapater8;

import java.util.concurrent.Exchanger;

/**
 * 博客地址：https://blog.csdn.net/octopusflying/article/details/80634864
 * Exchanger类可用于两个线程之间交换信息。可简单地将Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。
 * 当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 * created by yeric on 2019/7/26
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerTest test1 = new ExchangerTest(exchanger, "string1",
                "thread-1");
        ExchangerTest test2 = new ExchangerTest(exchanger, "string2",
                "thread-2");

//        ExchangerTest test3 = new ExchangerTest(exchanger, "string3", "thread-3");
        test1.start();
        test2.start();
//        test3.start();
    }
   static class  ExchangerTest extends Thread {
        private Exchanger<String> exchanger;
        private String string;
        private String threadName;

        public ExchangerTest(Exchanger<String> exchanger, String string,
                             String threadName) {
            this.exchanger = exchanger;
            this.string = string;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            try {
                System.out.println(threadName + ": " + exchanger.exchange(string));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
