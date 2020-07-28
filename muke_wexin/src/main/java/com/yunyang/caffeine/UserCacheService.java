package com.yunyang.caffeine;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yeric
 * @date 2020/7/21 14:17
 */
@Service
public class UserCacheService {
    /**
     * 查找
     * 先查缓存，如果查不到，会查数据库并存入缓存
     *
     * @param id
     */
    @Cacheable(value = "userCache", key = "#id", sync = true)
    public User getUser(long id) {
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        System.out.println("[getUser]");
        return user;
        //查找数据库
    }

    /**
     * 更新/保存
     *
     * @param user
     */
    @CachePut(value = "userCache", key = "#user.id")
    public void saveUser(User user) {
        System.out.println("[saveUser]");
    }


    /**
     * 删除
     *
     * @param user
     */
    @CacheEvict(value = "userCache", key = "#user.id")
    public void delUser(User user) {
        System.out.println("[delUser]");
    }
}
