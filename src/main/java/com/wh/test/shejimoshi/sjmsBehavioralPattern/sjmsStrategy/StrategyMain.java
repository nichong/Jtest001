package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsStrategy;

//策略模式仅仅封装算法,具体用哪个算法由调用方自己决定

/**
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 */
public class StrategyMain {
    public static void main(String[] args) {
        Strategy strategy = new StrategyC();
        //Strategy strategy = new StrategyB();
        Context context = new Context(strategy);
        context.printPrice(100);
    }
}