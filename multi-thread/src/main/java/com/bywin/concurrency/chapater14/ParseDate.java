package com.bywin.concurrency.chapater14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat.parse()不是线程安全的
 * created by yeric on 2019/7/29 20:37
 */
public class ParseDate implements Runnable{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ParseDate(i));
        }
    }
    int i = 0;
    public ParseDate(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Date t = sdf.parse("2019-07-29 20:46:" + i % 60);
            System.out.println(i + ":" + t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
