package com.yunyang.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeric
 * @date 2020/8/2 20:07
 */
@RestController
public class HomeController {
    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("/resource")
    public String resource () {
        return "resource";
    }
}
