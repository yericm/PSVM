package com.bywin.design_patterns.chapater5;

/**
 * 开灯命令
 * created by yeric on 2019/8/13
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
