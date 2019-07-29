package com.bywin.concurrency.chapater14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by yeric on 2019/7/29 20:37
 */
public class ThreadLocalDemo implements Runnable{

    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ThreadLocalDemo(i));
        }
    }
    int i = 0;
    public ThreadLocalDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if (t1.get() == null) {
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date t = t1.get().parse("2019-07-29 20:46:" + i % 60);
            System.out.println(i + ":" + t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
