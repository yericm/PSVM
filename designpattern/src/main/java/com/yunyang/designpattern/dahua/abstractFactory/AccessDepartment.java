package com.yunyang.designpattern.dahua.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:33
 */
public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("给access 部门新增了一条数据");
    }

    @Override
    public Department getDepartment() {
        System.out.println("从access 根据ID获取一条记录");
        return null;
    }
}
