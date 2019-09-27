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

    public static void main(String[] args) {
        try {
            int aa = aa();
            System.out.println(aa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
/*        int aa = aa();
        System.out.println(aa);*/
        System.out.println("sji");
    }

    public static  int aa () throws Exception{
//        try {
            System.out.println("123");
            int a = 1 / 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
        System.out.println("333333333");
        return 2;
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
