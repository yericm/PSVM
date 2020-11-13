package com.yunyang.designpattern.dahua.dataAccess;

import com.yunyang.designpattern.dahua.abstractFactory.Department;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:32
 */
public interface IDepartment {
    void insert(Department department);
    Department getDepartment();
}
