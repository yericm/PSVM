package com.bywin.concurrency.chapater10;

/**
 * created by yeric on 2019/7/16
 */
public class BarrierRun implements Runnable {
    private boolean flag;
    private int N;

    public BarrierRun(boolean flag, int n) {
        this.flag = flag;
        N = n;
    }

    @Override
    public void run() {
        if (flag) {
            System.out.println("司令：士兵【" + N + "】个，任务完成！");
        }else {
            System.out.println("司令：士兵【" + N + "】个，集合完毕！");
            flag = true;
        }
    }
}
