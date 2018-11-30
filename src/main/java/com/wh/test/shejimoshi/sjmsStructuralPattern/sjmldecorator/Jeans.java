package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmldecorator;

/** 牛仔裤 */
public class Jeans extends Decorator {
    @Override
    public void show(){
        System.out.println("穿牛仔裤");
        super.show();
    }

}
