package com.yunyang.designpattern.strategy.part3;

import org.springframework.stereotype.Component;

/**
 * @author yeric
 * @description:
 * @date 2020/12/31 22:20
 */
@Component
public class AddOperation implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
