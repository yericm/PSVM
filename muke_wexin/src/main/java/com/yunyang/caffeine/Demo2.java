package com.yunyang.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @date 2020/7/20 17:26
 */
public class Demo2 {
    public static void main(String[] args) {

        Object o = asyncOperator("appId");
        System.out.println(o);

    }

    /**
     * 异步加载
     *
     * @param key
     * @return
     */
    public static Object asyncOperator(String key) {
        AsyncLoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(7200, TimeUnit.MINUTES)
                .buildAsync(k -> setAsyncValue(key).get());

        return cache.get(key);
    }

    public static CompletableFuture<Object> setAsyncValue(String key) {
        return CompletableFuture.supplyAsync(() -> {
            return key + "value";
        });
    }
}
