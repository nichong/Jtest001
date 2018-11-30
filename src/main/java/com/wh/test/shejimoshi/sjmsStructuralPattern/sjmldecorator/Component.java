package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmldecorator;

/*
装饰模式:
Component是定义一个对象接口，可以给这些对象动态地添加职责。
ConcreteComponent是定义了一个具体的对象，也可以给这个对象添加一些职责
Decorator是装饰抽象类，继承了Component,从外类来扩展Component类的功能，
   但对于Component来说，是无需知道Decorator存在的。ConcreteDecorator就是具体的装饰对象，起到给Component添加职责的功能。

示例:
假设情景：某人装扮自己形象，穿衣服，裤子，鞋子，戴帽子等来把自己给包装起来，需要把所需的功能按正确的顺序串联起来进行控制
 */
public interface Component {
    void show();
}
