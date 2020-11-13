package com.yunyang.designpattern.dahua.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:27
 */
public class SqlSeverFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlSeverUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlSeverDepartment();
    }
}
