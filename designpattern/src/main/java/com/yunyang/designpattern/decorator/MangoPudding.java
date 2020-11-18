package com.yunyang.designpattern.decorator;


/**
 * @author yeric
 * @description:
 * @date 2020/11/16 08:24
 */
public class MangoPudding implements MilkTea {
    @Override
    public String  description() {
        return "芒果布丁奶茶";
    }

    @Override
    public int cost() {
        return 15;
    }
}
