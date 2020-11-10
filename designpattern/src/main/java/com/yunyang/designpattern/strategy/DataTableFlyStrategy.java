package com.yunyang.designpattern.strategy;

/**
 * @author yeric
 * @date 2020/11/10 08:01
 */
public class DataTableFlyStrategy implements ApprovalStrategy {
    @Override
    public void approval() {
        System.out.println("数据表审批");
    }
}
