package com.bywin.design_patterns.chapater7.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yeric on 2019/8/14
 */
public class MainClass {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List listProxy = (List)new ArrayListProxy(list).getArrayListProxy();
        listProxy.add("1");
        listProxy.stream().forEach(System.out::print);
    }
}
