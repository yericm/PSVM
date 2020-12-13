package com.yunyang.designpattern.ChainOfResponsibility.one;

/**
 * @author yeric
 * @description:
 * @date 2020/11/20 08:04
 */
public class Main {
    public static void main(String[] args) {
        RequestP requestP = new RequestP();
        requestP.setName("组长");
        requestP.setNum(3);
        Handler concreteHandler1 = new ConcreteHandler1();
        Handler concreteHandler2 = new ConcreteHandler2();
        Handler concconcreteHandler3 = new ConcreteHandler3();
        concreteHandler1.setNextHandler(concreteHandler2);
        concreteHandler2.setNextHandler(concconcreteHandler3);
        concreteHandler1.handlerResquest(requestP);
    }
}
