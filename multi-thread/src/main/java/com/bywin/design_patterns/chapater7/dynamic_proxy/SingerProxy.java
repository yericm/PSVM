package com.bywin.design_patterns.chapater7.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by yeric on 2019/8/14
 */
public class SingerProxy {
    /**
     * 维护一个目标对象
     */
    private ISinger target;

    public SingerProxy(ISinger target) {
        this.target = target;
    }

    public Object getSingerProxyInstance () {
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (args != null && args.length > 1) {
                    System.out.println("歌曲信息");
                }
//                System.out.println("调用的方法是：" + method.getName());
                Object invoke = method.invoke(target, args);
                System.out.println("谢谢大家");
                return invoke;
            }
        });
    }
}
