package com.bywin.concurrency.chapater9;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写分离锁，减少锁竞争提升性能，多个读锁之间是并行执行
 * 使用读写锁运行此程序只需要3s左右，使用重入锁需要20s
 * created by yeric on 2019/7/16
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                // 使用读锁，多线程之间并行不会阻塞
//                demo.handleRead(readLock);
                // 使用普通的重入锁
                demo.handleRead(lock);
            }
        };
        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
//                demo.handleWrite(writeLock, new Random().nextInt());
                // 使用普通的重入锁
                demo.handleWrite(lock, new Random().nextInt());
            }
        };
        for (int i = 0; i < 18; i++) {
            new Thread(runnable).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(runnable1).start();
        }
    }

    public Object handleRead(Lock lock) {
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) {
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
