package com.bywin.concurrency.chapater8;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 博客地址：https://www.cnblogs.com/stateis0/p/9062018.html
 * ForkJoinTask 是ForkJoinPool线程池的一个接口,所谓 ForkJoinTask 任务就是支持 fork （） 分解以及 join（）等待的任务。
 * ForkJoinTask 有两个重要的子类，RecursiveAction 和 RecursiveTask。他们分别表示没有返回值的任务和可以携带返回值的任务。有点像 Rannable 和 Callable。
 * created by yeric on 2019/7/29
 */
public class ForkJoinPoolDemo extends RecursiveTask<Long> {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinPoolDemo task = new ForkJoinPoolDemo(0, 200000L);
        // 将一个大的任务提交到池中
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = 0;
        try {
            // 等待运算结果
            res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 阀值
     */
    static final int THRESHOLD = 10000;
    long start;
    long end;

    public ForkJoinPoolDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        // 当阀值小于10000则不分解了
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 2000
            long step = (start + end) / 100;
            ArrayList<ForkJoinPoolDemo> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                //0-2000 个计算任务 * 100
                ForkJoinPoolDemo subTask = new ForkJoinPoolDemo(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();// fork
            }

            for (ForkJoinPoolDemo t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }
}
