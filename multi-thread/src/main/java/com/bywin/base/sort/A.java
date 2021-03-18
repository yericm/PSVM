package com.bywin.base.sort;

import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.regex.REUtil;
import org.springframework.util.CollectionUtils;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yeric
 * @description:
 * @date 2021/1/19 08:05
 */
public class A {

    private static final String CONN_UNION_MAPPING_PREFIX = "conn|union|mapping";


    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        String mobile = "18208973297";
        String email = "1427@163.com";
        String m = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(m);
        String e = email.replaceAll("(\\w+)\\w{3}@(\\w+)", "$1***@$2");
        System.out.println(e);
        String fullName = "莫彬";
        String name = StringUtils.left(fullName, 1);
        String tun = StringUtils.rightPad(name, StringUtils.length(fullName), "*");
        System.out.println(tun);
        String rtnStr = "0896-098765";
        rtnStr = replace(rtnStr,rtnStr.length()-3,"****");
        System.out.println(rtnStr);

    }

    public static String replace (String str,int n,String newChar){
        String s1="";
        String s2="";
        try{
            s1=str.substring(0,n-1);
            s2=str.substring(n-1+newChar.length());
            return s1+newChar+s2;
        }catch(Exception ex){
            return str;
        }
    }

    public static Integer a() {
        int j = 3;
        for (int i = 0; i < 10; i++) {
            if (j == i) {
                return i;
            }
            System.out.println(i);
        }
        return null;
    }

    /**
     * 获取主机名
     *
     * @return
     */
    public static String getHostName() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            System.out.println(hostName);
            return hostName;
        } catch (UnknownHostException e) {
            return "";
        }
    }
}
