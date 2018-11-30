package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsgcz;

/**
 * Subject(目标，Subject)：    
 * 目标知道它的观察者。可以有任意多个观察者观察同一个目标。  
 * 提供注册和删除观察者对象的接口。  
 */
public interface Subject {
    public void addWatch(Observers mObserver);//添加观察者
    public void delWatch(Observers mObserver);//删除观察者
    public void notice();//通知观察者
} 