package com.bywin.design_patterns.chapater7.dynamic_proxy;


/**
 * created by yeric on 2019/8/14
 */
public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("在唱歌");
    }

    /**
     * 获得歌曲信息
     * @param singName
     * @param auth
     * @return
     */
    @Override
    public void singInfo (String singName, String auth) {
        System.out.println("歌曲名：" + singName + "   演唱：" + auth);
    }
}
