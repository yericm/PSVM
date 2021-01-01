package com.yunyang.designpattern.strategy.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:23
 */
@Component
public class CalculatelOperationContext {
    private final Map<String, CalculateStrategy> strategyMap = new ConcurrentHashMap<>();

    @Autowired
    public void stragegyInteface(Map<String, CalculateStrategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach(this.strategyMap::put);
        System.out.println(this.strategyMap);
    }


    @Autowired
    public void stragegyInteface2(List<CalculateStrategy> strategyMap) {
        strategyMap.forEach(System.out::println);
    }

    public CalculateStrategy strategySelect(String mode) {
        return this.strategyMap.get(mode);
    }
}
