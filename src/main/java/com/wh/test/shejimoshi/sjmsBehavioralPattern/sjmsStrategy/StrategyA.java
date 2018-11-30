package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

public class StrategyA implements Strategy{
    public double getPrice(double price) {
        System.out.println("普通客户小批量，不打折");
        return price;
    }
}
