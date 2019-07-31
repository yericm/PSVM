package com.bywin.design_patterns.chapater1;

/**
 * 最优的单例模式
 */
public class Singleton {
    private Singleton() {}
    private static class insideCreate {
        private static Singleton instance = new Singleton();
    }
    // 该方法没有加锁，使得高并发环境下性能优越，另外，只有在第一次调用这个方法时才会创建Singleton实例
    public static Singleton getInstance () {
        return insideCreate.instance;
    }
}
