package com.bywin.base.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * created by yeric on 2019/8/7
 */
public class TestDemo {

    public static void main(String[] args) throws IOException {
/*        HashSet<Person> set = new HashSet<Person>();
        set.add(new Person(110,"狗娃"));
        set.add(new Person(110,"狗娃1"));
        System.out.println("集合的元素："+ set);*/

        List<String> list = new ArrayList<String>();
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        list.add("张三5");
        list.add("张三6");

        //使用迭代器遍历ArrayList集合
        Iterator<String> listIt = list.iterator();
        while (listIt.hasNext()) {
            Object obj = listIt.next();
            System.out.println("remove 前：" + obj);
            if (obj.equals("张三3")) {
//                list.remove(obj);
                listIt.remove();
            }
        }
        for (String l : list) {
            System.out.println(l);
        }

    }
}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.id == p.id;
    }

    @Override
    public String toString() {
        return "编号：" + this.id + " 姓名： " + this.name;
    }
}
