package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

//Context环境角色: 持有一个Strategy的引用。
public class Context {
    private Strategy strategy;//持有策略引用

    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }
    public void printPrice(double price ){
        System.out.println("价格为："+strategy.getPrice(price));
    }
}