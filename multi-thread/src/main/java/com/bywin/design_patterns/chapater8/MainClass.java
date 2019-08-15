package com.bywin.design_patterns.chapater8;


/**
 * 迭代器模式 博客地址：https://www.cnblogs.com/yangxiaojie/p/10205208.html
 * created by yeric on 2019/8/15
 */
public class MainClass {
    public static void main(String[] args) {
        ArrMenu arrMenu = new ArrMenu();
        ListMenu listMenu = new ListMenu();
        System.out.println("---------------数组 菜类---------------");
        printMenu(arrMenu.createIterator());
        System.out.println("---------------集合 汤类---------------");
        printMenu(listMenu.createIterator());
    }

    private static void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem next = iterator.next();
            System.out.println("menu name is :" + next.getName());
            System.out.println("menu description is :" + next.getDesc());
            System.out.println("menu price is :" + next.getPrice());
        }
    }
}
