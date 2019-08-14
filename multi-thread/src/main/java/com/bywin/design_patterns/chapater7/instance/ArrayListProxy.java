package com.bywin.design_patterns.chapater7.instance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * ArrayList动态代理类
 * created by yeric on 2019/8/14
 */
public class ArrayListProxy {
    private List target;

    public ArrayListProxy(List target) {
        this.target = target;
    }

    public Object getArrayListProxy () {
       return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("add")) {
                    System.out.println("调用的是新增方法");
                }else if (method.getName().equals("remove")){
                    System.out.println("调用的是删除方法");
                }else {
                    System.out.println("调用的其它方法");
                }
                Object invoke = method.invoke(target, args);
                System.out.println("调用方法结束后");
                return invoke;
            }
        });
    }
}
