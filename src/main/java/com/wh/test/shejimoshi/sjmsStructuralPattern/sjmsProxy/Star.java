package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsProxy;

/**
 * 抽象角色：提供代理角色和真实角色(委托类)对外提供的公共方法
 *
 * 代理类与委托类有同样的接口，代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等
 *
 *  **********************************************
 * 代理与外观模式的区别：
 * 代理中  代理角色和真实角色都实现公有方法
 * 外观中  client通过Facade集成的方法去实现访问其他模块功能
 */
public interface Star {
    void confer();//面谈（假定，经纪人来做这个事情）
    void sing();//唱歌（明星只负责唱歌）
}
