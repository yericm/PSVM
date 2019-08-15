package com.bywin.design_patterns.chapater8;

/**
 * 数组菜单
 * created by yeric on 2019/8/15
 */
public class ArrMenu {
    private final int MAX_ITEMS = 3;
    int items;

    MenuItem[] menuItems;

    public ArrMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("西红柿鸡蛋", "有营养", 10.00);
        addItem("酸辣白菜", "好吃", 11.00);
        addItem("酸辣土豆丝", "特色菜", 12.00);
    }

    public void addItem(String name, String description, Double price) {
        MenuItem menuItem = new MenuItem(name, description, price);
        if (items >= MAX_ITEMS) {
            System.err.println("menu is full,Can't add item to menu");
        } else {
            menuItems[items] = menuItem;
            items += 1;
        }
    }

    public Iterator createIterator() {
        return new ArrMenuIterator(menuItems);
    }
}
