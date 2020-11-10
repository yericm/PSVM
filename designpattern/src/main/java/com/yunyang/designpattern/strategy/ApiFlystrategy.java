package com.yunyang.designpattern.strategy;

/**
 * @author yeric
 * @date 2020/11/10 08:03
 */
public class ApiFlystrategy implements ApprovalStrategy {
    @Override
    public void approval() {
        System.out.println("api审批");
    }
}
