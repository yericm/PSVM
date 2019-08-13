package com.bywin.design_patterns.chapater5;

/**
 * 关灯命令
 * created by yeric on 2019/8/13
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}
