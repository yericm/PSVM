package com.bywin.design_patterns.chapater8;

import java.util.List;

/**
 * list迭代器
 * created by yeric on 2019/8/15
 */
public class ListMenuIterator implements Iterator<MenuItem> {
    private List<MenuItem> listMenu;
    int position = 0;

    public ListMenuIterator(List listMenu) {
        this.listMenu = listMenu;
    }

    @Override
    public boolean hasNext() {
        if (position >= listMenu.size() || listMenu.get(position) == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        return listMenu.get(position++);
    }
}
