package com.bywin.concurrency.chapater11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 核心参数
 * 通过 ThreadPoolExecutor 创建线程池，有几个核心参数：
 *
 * corePoolSize 线程池中的核心线程数量；
 * maximumPoolSize 当前线程池正在运行的最大线程数量；
 * keepAliveTime 超过 corePoolSize 线程数量的线程最大空闲时间；
 * unit 以秒为时间单位；
 * workQueue 创建工作队列，用于存放提交的等待执行任务；
 *
 * 执行流程
 * 在了解了核心参数后，这里来描述一下上面案例的执行流程：
 *
 * 首先通过 ThreadPoolExecutor 构造函数创建线程池；
 * 执行 for 循环，提交 12 个任务（为什么是12个任务呢？）；
 * 通过 threadPoolExecutor.submit 提交 Runnable 接口实现的执行任务；
 * 提交第1个任务时，由于当前线程池中正在执行的任务为 0 ，小于 5（corePoolSize 指定），所以会创建一个线程用来执行提交的任务1；
 * 提交第 2， 3， 4， 5 个任务的时候，由于当前线程池中正在执行的任务数量小于等于 5 （corePoolSize 指定），所以会为每一个提交的任务创建一个线程来执行任务；
 * 当提交第6个任务的时候，由于当前正在执行的任务数量为 5 （因为每个线程任务执行时间为10s，所以提交第6个任务的时候，前面5个线程都还在执行中），此时会将第6个任务存放到 workQueue 队列中等待执行；
 * 由于 workQueue 队列的大小为 2 ，所以该队列中也就只能保存 2 个等待执行的任务，所以第7个任务也会保存到任务队列中；
 * 当提交第8个任务的时候，因为当前线程池正在执行的任务数量为5，workQueue 队列中存储的任务数量也满了，这时会判断当前线程池中正在执行的任务的数量是否小于10（maximumPoolSize指定）；
 * 如果小于 10 ，那么就会新创建一个线程来执行提交的任务 8；
 * 执行第9,10,11,12个任务的时候，也要判断当前线程池中正在执行的任务数是否小于10（maximumPoolSize指定），如果小于10，那么也会立即新建线程来执行这些提交的任务；
 * 此时，12个任务都已经提交完毕，那 workQueue 队列中的等待 任务6 和 任务7 什么时候执行呢？
 * 当任务1执行完毕后（10s后），执行任务1的线程并没有被销毁掉，而是获取 workQueue 中的任务6来执行；
 * 当任务2执行完毕后，执行任务2的线程也没有被销毁，而是获取 workQueue 中的任务7来执行；
 *
 * 通过上面流程的分析，也就知道了之前案例的输出结果的原因。其实，线程池中会线程执行完毕后，并不会被立刻销毁，线程池中会保留 corePoolSize 数量的线程，当 workQueue 队列中存在任务或者有新提交任务时，那么会通过线程池中已有的线程来执行任务，避免了频繁的线程创建与销毁，而大于 corePoolSize 小于等于 maximumPoolSize 创建的线程，则会空闲指定时间（keepAliveTime）后进行回收。
 * created by yeric on 2019/7/23 22:57
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws Exception {
        //核心线程数
        int corePoolSize = 5;
        //最大线程数
        int maximumPoolSize = 10;
        //超过 corePoolSize 线程数量的线程最大空闲时间
        long keepAliveTime = 1;
        //以秒为时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //创建工作队列，用于存放提交的等待执行任务
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
       /* 1、corePoolSize, 核心线程数，建议和cpu的核心数差不多，当有任务提交，检测当前线程池内的线程数小于corePoolSize的话，新建线程执行任务，而不会开始复用，会新建，直到达到corePoolSize。线程池内的线程数大于等于corePoolSize时，将任务放入workQueue等待。
        2、maximumPoolSize，允许线程池内最大线程数，当队列满了之后，如果线程池内的线程数小于maximumPoolSize新建线程，如果大于等于执行拒绝策略。
        如果maximumPoolSize是30，corePoolSize是10，当队列满了后只能再开20个线程。
        3、keepAliveTime，线程池空闲时，线程存活的时间。
        4、workQueue，上面提到的线程数超过corePoolSize存放任务的地方。
        5、threadFactory，线程工厂，可以自己重写一下，为每个线程赋予一个名字，便于排查问题。
        6、handler，拒绝策略，分4种，AbortPolicy直接抛出异常、DiscardPolicy悄悄抛弃不执行、CallerRunsPolicy（调用者运行）：该策略既不会抛弃任务也不会抛出异常，而是将这个任务退回给调用者，从而降低新任务的流量；、DiscardOldestPolicy（抛弃最旧的）
        */
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,
                        unit,
                        workQueue);

        //循环提交任务
        for(int i = 0; i < 12; i++) {
            //提交任务的索引
            final int index = (i + 1);
            threadPoolExecutor.submit(() -> {
                //线程打印输出
                System.out.println("大家好，我是线程：" + index);
                try {
                    //模拟线程执行时间，10s
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            //每个任务提交后休眠500ms再提交下一个任务，用于保证提交顺序
            Thread.sleep(500);
            System.out.println("活跃的线程数：" + threadPoolExecutor.getActiveCount());
        }
    }
}
