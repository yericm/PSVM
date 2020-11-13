package com.yunyang.designpattern.dahua.dataAccess;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:24
 */
public class SqlSeverUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在SqlSever中给user表增加一条记录");
    }

    @Override
    public User getUser() {
        System.out.println("在SqlSever中根据ID从user表获取用户信息");
        return null;
    }
}
