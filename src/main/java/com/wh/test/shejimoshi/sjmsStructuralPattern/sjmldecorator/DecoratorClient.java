package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmldecorator;

/**
 * 装饰模式测试客户端
 */
public class DecoratorClient {
    public static void main(String[] args) {
        DecoratorPerson mPerson = new DecoratorPerson("Andy");

        Jeans mJeans = new Jeans();
        TShirt mShirt = new TShirt();

        mShirt.decoratorObj(mPerson);
        mJeans.decoratorObj(mShirt);
        mJeans.show();
    }
}