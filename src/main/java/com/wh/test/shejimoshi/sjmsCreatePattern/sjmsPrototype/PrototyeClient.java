package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsPrototype;

/*
 原型模式   https://blog.csdn.net/jason0539/article/details/23158081
 原型模式主要用于对象的复制

 使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，
 它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显
 */
public class PrototyeClient {
    public static void main(String[] args){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
            clonecp.show();
        }
    }
}

/**
 * 原型类Prototype implements Cloneable接口，并重写clone（）方法
 */
class Prototype implements Cloneable {
    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcretePrototype extends Prototype{

    public void show(){
        System.out.println("原型模式实现类");
    }
}
