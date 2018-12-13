package com.wh.test.generictype.test;

public class Person implements Cloneable{
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person("p");
        Person p1 = (Person) p.clone();
        Person p2 = p;
        System.out.println(p);
        System.out.println(p1);
        System.out.println("===========");
        System.out.println(p);
        System.out.println(p2);
    }
}
