package com.yunyang.designpattern.strategy.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:24
 */
@RestController
public class StrategyController {
    @Autowired
    private CalculatelOperationContext calculatelOperationContext;

    @RequestMapping(value = "/operation")
    public String strategySelect(@RequestParam("mode") String mode) {
        return String.valueOf(calculatelOperationContext.strategySelect(mode).doOperation(20, 5));
    }
}
