package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory;

public class Teacher extends Person {
    public Teacher(){
        System.out.println("create Teacher");
    }
    @Override
    public  void disName(){
        System.out.println("Teacher disName");
    }
}
