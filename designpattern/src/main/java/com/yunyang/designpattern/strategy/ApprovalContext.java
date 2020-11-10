package com.yunyang.designpattern.strategy;

/**
 * 环境角色类
 * @author yeric
 * @date 2020/11/10 08:08
 */
public class ApprovalContext {
    // 私有化申明抽象角色变量
    private ApprovalStrategy approvalStrategy;

    // 重载构造方法
    public ApprovalContext(ApprovalStrategy approvalStrategy) {
        this.approvalStrategy = approvalStrategy;
    }

    // 执行抽象方法
    public void approval () {
        approvalStrategy.approval();
    }

    // 测试代码
    public static void main(String[] args) {
        new ApprovalContext(new ApiFlystrategy()).approval();
        new ApprovalContext(new TopicFlyStrategy()).approval();
        new ApprovalContext(new TopicFlyStrategy()).approval();
    }
}
