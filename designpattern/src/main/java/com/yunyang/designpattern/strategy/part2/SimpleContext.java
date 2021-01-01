package com.yunyang.designpattern.strategy.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:13
 */
@Service
public class SimpleContext {
    @Autowired
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
        System.out.println(strategyMap);
    }

    public String getResource(String poolId){
        return strategyMap.get(poolId).getVpcList(poolId);
    }

}
