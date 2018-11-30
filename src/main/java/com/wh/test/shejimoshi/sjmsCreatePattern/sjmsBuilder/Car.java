package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsBuilder;

//1.Product角色:组装一辆汽车首先的有各种配件，如发动机、轮胎、座椅等
public class Car{
    public String engine;
    public String tyre;
    public String seat;
    public Car(){

    }

    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getTyre() {
        return tyre;
    }
    public void setTyre(String tyre) {
        this.tyre = tyre;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }

}