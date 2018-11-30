package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsfactory.sjmsSingplefactory;

public class BeanFactory {

    public static Object getClass(Class<? extends Person> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
    public static void main(String[] args){
        Student obj1 = (Student) BeanFactory.getClass(Student.class);
        obj1.disName();

        Teacher obj2 = (Teacher) BeanFactory.getClass(Teacher.class);
        obj2.disName();
    }
}
