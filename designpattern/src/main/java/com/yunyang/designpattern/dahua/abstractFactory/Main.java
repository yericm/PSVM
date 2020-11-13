package com.yunyang.designpattern.dahua.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:28
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();
        SqlSeverFactory factory = new SqlSeverFactory();
//        AccessFactory factory = new AccessFactory();
        IUser iu = factory.createUser();
        IDepartment dt = factory.createDepartment();
        iu.insert(user);
        iu.getUser();
        dt.insert(department);
        dt.getDepartment();
    }
}
