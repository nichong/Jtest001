package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory;

public class Student extends Person {
    public Student(){
        System.out.println("create Student");
    }
    @Override
    public void disName(){
        System.out.println("Student disName");
    }
}
