package com.yunyang.caffeine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeric
 * @date 2020/7/21 14:24
 */
@RestController
public class UserController {
    @Autowired
    private UserCacheService userCacheService;

    @GetMapping("/getUser")
    public User getUser() {
        return userCacheService.getUser(1L);
    }

    @GetMapping("/saveUser")
    public String saveUser() {
        User user = new User();
        user.setId(1L);
        user.setName("张三更新");
        userCacheService.saveUser(user);
        return "saveUser ok";
    }

    @GetMapping("/delUser")
    public String delUser() {
        User user = new User();
        user.setId(1L);
        user.setName("张三删除");
        userCacheService.delUser(user);
        return "delUser ok";
    }
}
