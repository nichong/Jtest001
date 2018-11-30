package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmldecorator;

public class Decorator implements Component{
    private Component mComponent;
    public void decoratorObj(Component component){
        mComponent = component;
    }

    public void show() {
        if(mComponent != null){
            mComponent.show();
        }
    }
}
