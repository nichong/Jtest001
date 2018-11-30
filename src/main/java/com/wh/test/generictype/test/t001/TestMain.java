package com.wh.test.generictype.test.t001;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wh.test.generictype.test.Student;


public class TestMain {
    public static void main(String[] args){
        Student s = new Student();
        s.setStNum(2);
        s.setName("Bob");
        String stuStr = JSONObject.toJSONString(s);
        Student s1 = parse(stuStr, Student.class);
        Student s12 = parse(stuStr, s.getClass());

        System.out.println(s12.getStNum());
    }

    public static <T> T parse(String str, Class<T> object){
        T t = JSON.parseObject(str, object);
        return t;
    }
}
