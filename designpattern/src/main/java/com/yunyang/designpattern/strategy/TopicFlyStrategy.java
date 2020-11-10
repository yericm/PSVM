package com.yunyang.designpattern.strategy;

/**
 * @author yeric
 * @date 2020/11/10 08:04
 */
public class TopicFlyStrategy implements ApprovalStrategy {
    @Override
    public void approval() {
        System.out.println("topic审批");
    }
}
