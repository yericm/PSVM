package com.yunyang.designpattern.ChainOfResponsibility.two;


/**
 * @author yeric
 * @description:
 * @date 2020/11/20 07:56
 */
public abstract class Handler {
    public Handler nextHandler;
    abstract Handler handlerResquest (RequestP requestP);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
