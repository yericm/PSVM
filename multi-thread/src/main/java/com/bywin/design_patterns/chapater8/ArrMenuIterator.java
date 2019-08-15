package com.bywin.design_patterns.chapater8;

/**
 * 数组迭代器
 * created by yeric on 2019/8/15
 */
public class ArrMenuIterator implements Iterator<MenuItem> {
    private MenuItem [] menuItems;
    int position = 0;

    public ArrMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position]==null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position++];
        return menuItem;
    }
}
