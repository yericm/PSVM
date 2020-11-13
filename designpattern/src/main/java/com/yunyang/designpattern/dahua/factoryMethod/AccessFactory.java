package com.yunyang.designpattern.dahua.factoryMethod;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:28
 */
public class AccessFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new AccessUser();
    }
}
