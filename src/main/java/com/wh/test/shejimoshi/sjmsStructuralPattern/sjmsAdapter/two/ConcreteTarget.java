package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsAdapter.two;

/**
 *具体目标类，只提供普通功能
 * @author weiH
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
