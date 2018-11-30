package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.abstractfactory;

//抽象工厂类
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
