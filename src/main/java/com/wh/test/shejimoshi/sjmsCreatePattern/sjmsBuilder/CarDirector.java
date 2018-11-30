package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsBuilder;

//4.Director角色:在生产出配件后，由指导者指导组装配件生成汽车。
public class CarDirector {
    Builder cb;
    public CarDirector(Builder cb){
        this.cb=cb;
    }
    public Car constructCar(){
        Car car=new Car();
        //解释： cb.buildEngine() 生产了引擎      car.setEngine（）；将引擎组装到car上   过程由指导者CarDirector控制
        car.setEngine(cb.buildEngine());
        car.setTyre(cb.buildTyre());
        car.setSeat(cb.buildSeat());
        return car;
    }
}
