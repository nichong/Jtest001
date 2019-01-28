package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsCommand;

/**
 * 开机命令ConcreteCommand
 */
public class CommandOn implements Command {
    private Tv myTv;

    public CommandOn(Tv tv) {
        myTv = tv;
    }

    public void execute() {
        myTv.turnOn();
    }
}


