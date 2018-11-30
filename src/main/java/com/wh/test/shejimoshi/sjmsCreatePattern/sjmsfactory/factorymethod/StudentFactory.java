package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.factorymethod;

import com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory.Person;
import com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory.Student;

public class StudentFactory extends Factory {
    @Override
    public Person createBean(){
        return new Student();
    }
}
