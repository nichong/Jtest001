package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

//Strategy抽象策略角色:
public interface Strategy {
    /**
     *
     * @param price 商品原价
     * @return 打折后价格
     */
    double getPrice(double price);

    /*
    StrategyA:普通客户小批量，不打折
    StrategyB:普通客户大 批量，打9折
    StrategyC:老客户小批量，打8.5折
     */
}
