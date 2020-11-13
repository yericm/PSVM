package com.yunyang.designpattern.dahua.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:25
 */
public class AccessUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在Access中给user表增加一条记录");
    }

    @Override
    public User getUser() {
        System.out.println("在Access中根据ID从user表获取用户信息");
        return null;
    }
}
