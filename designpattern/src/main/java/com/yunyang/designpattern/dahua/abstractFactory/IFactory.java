package com.yunyang.designpattern.dahua.abstractFactory;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:27
 */
public interface IFactory {
    IUser createUser();
    IDepartment createDepartment();
}
