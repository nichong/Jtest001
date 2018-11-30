package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsBuilder;

//3.ConcreteBuilder角色:实现抽象的 建造者接口生成具体的建造者，并开始生产具体的配件。
public class CarBuilder implements Builder{

    public String buildEngine() {
        // 生产发动机
        return "发动机";
    }

    public String buildTyre() {
        // 生产轮胎
        return "轮胎";
    }

    public String buildSeat() {
        // 生产座椅
        return "座椅";
    }
}
