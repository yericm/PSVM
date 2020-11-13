package com.yunyang.designpattern.dahua.dataAccess;

import com.yunyang.designpattern.dahua.abstractFactory.Department;
import com.yunyang.designpattern.dahua.abstractFactory.IDepartment;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:33
 */
public class SqlSeverDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("给sqlsever 部门新增了一条数据");
    }

    @Override
    public Department getDepartment() {
        System.out.println("从sqlsever根据ID获取一条记录");
        return null;
    }
}
