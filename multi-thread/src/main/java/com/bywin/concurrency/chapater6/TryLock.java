package com.bywin.concurrency.chapater6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * created by yeric on 2019/7/3
 * 重入锁 锁申请等待限时
 */
public class TryLock implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args) {
        new Thread(new TryLock(1)).start();
        new Thread(new TryLock(2)).start();
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            if (lock2.tryLock()) {
                                System.out.println(Thread.currentThread().getId() + ":my job done1");
                                return;
                            }
                        } catch (Exception e) {
                            lock2.unlock();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        lock1.unlock();
                    }
                }
            }
        }else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            if (lock1.tryLock()) {
                                System.out.println(Thread.currentThread().getId() + ":my job done2");
                                return;
                            }
                        } catch (Exception e) {
                            lock1.unlock();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }
}
