package com.yunyang.designpattern.dahua.factoryMethod;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:28
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
//        SqlSeverFactory factory = new SqlSeverFactory();
        AccessFactory factory = new AccessFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser();
    }
}
