package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

public class StrategyC implements Strategy{
    public double getPrice(double price) {
        System.out.println("老客户小批量，打8.5折");
        return price*0.85;
    }
}
