package com.bywin.concurrency.chapater12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable一般是和ExecutorService配合来使用的,在ExecutorService接口中声明了若干个submit方法的重载版本：
 *      <T> Future<T> submit(Callable<T> task);
 *      <T> Future<T> submit(Runnable task, T result);
 *      Future<?> submit(Runnable task);
 *
 * Callable和Runnable的区别如下：
 *
 * I    Callable定义的方法是call，而Runnable定义的方法是run。
 * II   Callable的call方法可以有返回值，而Runnable的run方法不能有返回值。
 * III  Callable的call方法可抛出异常，而Runnable的run方法不能抛出异常。
 *
 * Future提供了三种功能：
 *
 * 　　1）判断任务是否完成； boolean isDone();
 *
 * 　　2）能够中断任务；boolean cancel(boolean mayInterruptIfRunning);参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，则表示可以取消正在执行过程中的任务。
 *
 * 　　3）能够获取任务执行结果
 *             V get() 用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
 *             V get(long timeout, TimeUnit unit) 用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。;
 * created by yeric on 2019/7/25
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        // 定义3个Callable类型的任务
        MyCallable task1 = new MyCallable(0);
        MyCallable task2 = new MyCallable(1);
        MyCallable task3 = new MyCallable(2);
        // 创建一个执行任务的服务
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            // 提交并执行任务，任务启动时返回了一个Future对象，
            // 如果想得到任务执行的结果或者是异常可对这个Future对象进行操作
            Future future1 = es.submit(task1);
            // 获得第一个任务的结果，如果调用get方法，当前线程会等待任务执行完毕后才往下执行
            System.out.println("task1: " + future1.get());
            Future future2 = es.submit(task2);
            // 等待5秒后，再停止第二个任务。因为第二个任务进行的是无限循环
            Thread.sleep(5000);
            System.out.println("task2 cancel: " + future2.cancel(true));
            // 获取第三个任务的输出，因为执行第三个任务会引起异常
            // 所以下面的语句将引起异常的抛出
            Future future3 = es.submit(task3);
            System.out.println("task3: " + future3.get());
        } catch (Exception e) {
            System.out.println("Exception e::" + e.toString());

        }
        // 停止任务执行服务
        es.shutdownNow();
    }

    public static class MyCallable implements Callable {
        private int flag = 0;

        public MyCallable(int flag) {
            this.flag = flag;
        }

        public String call() throws Exception {
            if (this.flag == 0) {
                return "flag = 0";
            }
            if (this.flag == 1) {
                try {
                    while (true) {
                        System.out.println("looping.");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                return "false";
            } else {
                throw new Exception("Bad flag value!");

            }
        }
    }
}
