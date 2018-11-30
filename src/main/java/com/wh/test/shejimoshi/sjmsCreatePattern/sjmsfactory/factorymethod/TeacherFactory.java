package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.factorymethod;

import com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory.Teacher;
import com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory.Person;

public class TeacherFactory extends Factory{
    @Override
    public Person createBean(){
        return new Teacher();
    }
}
