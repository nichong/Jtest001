package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsBuilder;/*
建造模式是将复杂的内部创建封装在内部，对于外部调用的人来说，只需要传入建造者和建造工具，对于内部是如何建造成成品的，调用者无需关心。
建造者模式（Builder Pattern）就是为了将部件与组装分离开

三、建造者模式结构组成

Product: 表示被构造的复杂对象,其中包含需要构建的部件属性。
Builder: 创建一个产品对象的各个部件指定抽象接口。
ConcreteBuilder： 实现Builder的接口以构造和装配该产品的各个部件，定义并明确它所创建的表示。
Director： 调用具体建造者角色以创建产品对象。

https://blog.csdn.net/xu__cg/article/details/52923835
 */


//5.最终得到一辆汽车:
public class ClientMain {
    public static void main(String[] args) {
        //过程：CarBuilder负责生产需要的配件，CarDirector负责搭建汽车骨架（new），然后把配件安装进
        CarDirector carDirector=new CarDirector(new CarBuilder());
        Car car=carDirector.constructCar();
        System.out.println("这辆车由"+car.getEngine()+car.getTyre()+car.getSeat()+"组成");

    }
}
