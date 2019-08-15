package com.bywin.design_patterns.chapater8;

import java.util.ArrayList;

/**
 * list集合菜单
 * created by yeric on 2019/8/15
 */
public class ListMenu {
    ArrayList<MenuItem> menuItems;

    public ListMenu() {
        menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("紫菜鸡蛋汤", "有营养的汤", 6.00));
        menuItems.add(new MenuItem("豆腐脑", "早餐必备", 7.00));
        menuItems.add(new MenuItem("鱿鱼汤", "补充大脑", 8.00));
    }

    public Iterator createIterator() {
        return new ListMenuIterator(menuItems);
    }
}
