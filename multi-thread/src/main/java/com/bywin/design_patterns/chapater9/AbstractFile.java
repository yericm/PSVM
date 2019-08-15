package com.bywin.design_patterns.chapater9;

/**
 * 抽象文件类：抽象构件
 * created by yeric on 2019/8/15
 */
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
