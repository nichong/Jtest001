package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsCommand;

/**
 * 命令模式
 * https://blog.csdn.net/jason0539/article/details/45110355
 * 调用者→接受者→命令
 *
 * 本质：
 * 命令模式的本质是对命令进行封装，将发出命令的责任和执行命令的责任分割开
 *
 *使用场景：
 *将命令的请求者和调用者解耦；打包执行的命令
 *
 * 组成：
 * command 命令接口：
 * ConcreteCommand 命令接口的实现（可以多个），持有Receiver
 * Receiver接收者，真正执行命令的对象
 * Invoker 使用命令对象的入口
 *
 */

//实例： 模拟对电视机的操作有开机、关机、换台命令。
//执行命令的接口
public interface Command {
    void execute();
}
