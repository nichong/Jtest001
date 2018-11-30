package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.factorymethod;

import com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory.Person;

public abstract class Factory {
    public  abstract Person createBean();

    public static void main(String[] args){
        Factory fs = new StudentFactory();
        fs.createBean();

        Factory ft = new TeacherFactory();
        ft.createBean();
    }
}
