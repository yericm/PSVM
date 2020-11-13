package com.yunyang.designpattern.dahua.dataAccess;

import com.yunyang.designpattern.dahua.abstractFactory.AccessDepartment;
import com.yunyang.designpattern.dahua.abstractFactory.IDepartment;
import com.yunyang.designpattern.dahua.abstractFactory.SqlSeverDepartment;

/**
 * @author yeric
 * @description:
 * @date 2020/11/13 07:39
 */
public class DataAccess {
    /**
     * 版本一，常规写法，如果有新的产品需要增加switch，不方便
     */
    //    private static final String db = "Sqlsever";
//    private static final String db = "Access";
//
//    public static IUser createUser() {
//        IUser iu = null;
//        switch (db) {
//            case "Sqlsever":
//                iu = new SqlSeverUser();
//                break;
//            case "Access":
//                iu = new AccessUser();
//                break;
//        }
//        return iu;
//    }
//
//    public static IDepartment createDepartment() {
//        IDepartment iDepartment = null;
//        switch (db) {
//            case "Sqlsever":
//                iDepartment = new SqlSeverDepartment();
//                break;
//            case "Access":
//                iDepartment = new AccessDepartment();
//                break;
//        }
//        return iDepartment;
//    }
    /**
     * 版本二，利用反射技术来创建对象
     */
//    public static final String db = "SqlSever";
    public static final String db = "Access";
    public static IUser createUser () throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classPath = "com.yunyang.designpattern.dahua.dataAccess."+db+"User";
        Class<?> clazz = Class.forName(classPath);
        return (IUser)clazz.newInstance();
    }

    public static IDepartment createDepartment() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classPath = "com.yunyang.designpattern.dahua.dataAccess."+db+"Department";
        Class<?> clazz = Class.forName(classPath);
        return (IDepartment) clazz.newInstance();
    }
}
