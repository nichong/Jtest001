package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsgcz;

import java.util.Vector;
/*
也叫（发布-订阅模式）定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，
这个主题对象在状态发生变化时，会通知所有观察者对象。使它们能够自动更新自己。
例如：发广播，游戏中大喇叭，群聊
 */


//示例场景：老师有电话号码，学生需要知道老师的电话号码以便于在合适的时候拨打，
// 在这样的组合中，老师就是一个被观察者（Subject），学生就是需要知道信息的观察者，
// 当老师的电话号码发生改变时(发布信息)，学生（订阅）得到通知，并更新相应的电话记录
/**
 * 观察者(Observer)模式测试类   
 */
public class ObserverClient {
    public static void main(String[] args) {
        Vector students = new Vector();
        Teachers t = new Teachers();
        for(int i= 0;i<10;i++){
            Students st = new Students("学生"+i,t);
            students.add(st);
            //为发布者t添加观察者st
            t.addWatch(st);
        }

        t.setPhone("12345678");
        for(int i=0;i<3;i++)
            ((Students)students.get(i)).show();

        t.setPhone("87654321");
        for(int i=0;i<3;i++)
            ((Students)students.get(i)).show();
    }
} 