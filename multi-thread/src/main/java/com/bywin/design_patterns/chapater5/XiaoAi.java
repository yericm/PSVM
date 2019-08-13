package com.bywin.design_patterns.chapater5;

/**
 * created by yeric on 2019/8/13
 */
public class XiaoAi {
    private Command command;

    /**
     * 设置具体的命令
     *
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void doCommand() {
        command.execute();
    }
}
