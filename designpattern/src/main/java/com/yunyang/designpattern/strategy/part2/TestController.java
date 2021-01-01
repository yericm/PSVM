package com.yunyang.designpattern.strategy.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:14
 */
@RestController
public class TestController {
    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam("id") String poolId) {
        System.out.println("id是："+poolId);
        return simpleContext.getResource(poolId);
    }

}
