package com.yunyang.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author yeric
 * @date 2020/7/20 16:47
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Object o = manulOperator("abc:");
        System.out.println(o);
        Object o1 = manulOperator("abc:");
        System.out.println(o1);
    }

    public static Object manulOperator(String key) {
        Cache<String, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(1000, TimeUnit.SECONDS)
                .expireAfterAccess(1000, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        //如果一个key不存在，那么会进入指定的函数生成value
        Object value = cache.get(key, t -> setValue(key).apply(key));
        cache.put("hello", value);

        //判断是否存在如果不存返回null
        Object ifPresent = cache.getIfPresent(key);
        //移除一个key
        cache.invalidate(key);
        return value;
    }

    public static Function<String, Object> setValue(String key) {
        System.out.println("调用function了");
        return t -> key + "value";
    }
}
