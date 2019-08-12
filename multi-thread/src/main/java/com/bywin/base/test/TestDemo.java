package com.bywin.base.test;

import java.io.IOException;
import java.util.HashSet;

/**
 * created by yeric on 2019/8/7
 */
public class TestDemo {

    public static void main(String[] args) throws IOException {
        HashSet<Person> set = new HashSet<Person>();
        set.add(new Person(110,"狗娃"));
        set.add(new Person(110,"狗娃1"));
        System.out.println("集合的元素："+ set);
    }
}
class Person{
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
        Person p = (Person)obj;
        return this.id == p.id;
    }
    @Override
    public String toString() {
        return "编号："+ this.id +" 姓名： "+ this.name;
    }
}
