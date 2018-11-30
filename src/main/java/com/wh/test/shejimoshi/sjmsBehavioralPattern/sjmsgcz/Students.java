package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsgcz;

/**
 * ConcreteObserver(具体观察者, Student)：
 * 维护一个指向ConcreteSubject(Teachers)对象的引用。
 * 存储有关状态，这些状态应与目标的状态保持一致。
 * 实现Observer的更新接口以使自身状态与目标的状态保持一致。
 */
public class Students implements Observers {

    private String name;
    private String phone;
    private Teachers mTeacher;

    public Students(String name, Teachers t){
        this.name = name;
        mTeacher = t;
    }

    public void show(){
        System.out.println("Name:"+name+"\nTeacher'sphone:" + phone);
    }
    public void update() {
        phone = mTeacher.getPhone();
    }
}
