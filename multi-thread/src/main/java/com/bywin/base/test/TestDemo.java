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
        try {
            System.out.println("正常执行代码");
            System.out.println(1 / 0);
            System.out.println("抛出异常之后的代码");
        } catch (Exception e) {

        }
        System.out.println("try catch执行后的代码");
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
