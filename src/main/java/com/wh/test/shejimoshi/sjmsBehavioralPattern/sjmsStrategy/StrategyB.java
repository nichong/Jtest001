package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

public class StrategyB implements Strategy{
    public double getPrice(double price) {
        System.out.println("普通客户大批量，打9折");
        return price*0.9;
    }
}
