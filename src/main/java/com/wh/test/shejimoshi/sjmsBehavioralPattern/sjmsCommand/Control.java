package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsCommand;

/**
 * 可以看作是遥控器Invoker
 *
 * Invoker持有命令Command， Command里面持有 命令接收者Receiver
 */
public class Control {
    private Command onCommand, offCommand, changeChannel;

    public Control(Command on, Command off, Command channel) {
        onCommand = on;
        offCommand = off;
        changeChannel = channel;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }

    public void changeChannel() {
        changeChannel.execute();
    }
}

