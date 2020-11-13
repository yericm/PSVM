package com.yunyang.designpattern.dahua.dataAccess;

import com.yunyang.designpattern.dahua.abstractFactory.Department;
import com.yunyang.designpattern.dahua.abstractFactory.IDepartment;

/**
 * @author yeric
 * @description: 利用反射来优化抽象工厂模式
 * 抽象产品，具体产品，具体创建产品的对象(DataAccess,这里面利用反射技术)
 * @date 2020/11/13 07:28
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        User user = new User();
        Department department1 = new Department();
        IUser iu = DataAccess.createUser();
        IDepartment department = DataAccess.createDepartment();
        iu.insert(user);
        iu.getUser();
        department.insert(department1);
        department.getDepartment();
    }
}
