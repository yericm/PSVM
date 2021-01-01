package com.yunyang.designpattern.strategy.part2;

import org.springframework.stereotype.Component;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:10
 */
@Component("B")
public class ResourceB implements Strategy {
    @Override
    public String getVpcList(String id) {
        System.out.println("B,getVpcList ==========="+id);
        return id;
    }

}
