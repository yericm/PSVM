package com.bywin.concurrency.chapater12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一个可根据需要创建新线程的线程池，如果现有线程没有可用的，则创建一个新线程并添加到池中，如果有被使用完但是还没销毁的线程，
 * 就复用该线程。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。
 * 这种线程池比较灵活，对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
 * created by yeric on 2019/7/25
 */
public class newCachedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
//        fuyong();
        destory();
    }

    /**
     * 可复用
     */
    public static void fuyong() {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
    }

    /**
     * 60s销毁
     * 输出的service对象里有一个属性pool size，他指的是线程池里的线程数，当过了60秒仍然没有任务来使用线程时，线程会自动释放。
     */
    public static void destory() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);

        TimeUnit.SECONDS.sleep(70);

        System.out.println(service);
    }
}
