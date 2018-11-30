package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmldecorator;

public class DecoratorPerson implements Component{
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DecoratorPerson(String name){
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的" + name);
    }
}
