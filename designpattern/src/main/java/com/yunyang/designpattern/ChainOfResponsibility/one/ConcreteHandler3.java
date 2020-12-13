package com.yunyang.designpattern.ChainOfResponsibility.one;

/**
 * @author yeric
 * @description:
 * @date 2020/11/20 07:59
 */
public class ConcreteHandler3 extends Handler {

    @Override
    Handler handlerResquest(RequestP requestP) {
        if (requestP.getNum() == 3) {
            System.out.println("处理器3完成处理"+requestP);
        }else {
            if (getNextHandler() != null) {
                nextHandler.handlerResquest(requestP);
            }else {
                System.out.println("没有下一个处理器去处理了----");
            }
        }
        return null;
    }
}
