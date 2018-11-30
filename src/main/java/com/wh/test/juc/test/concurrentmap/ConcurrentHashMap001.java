package com.wh.test.juc.test.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap001 extends ConcurrentHashMap {
    public static void main(String[] args){
        ConcurrentHashMap001 map = new ConcurrentHashMap001();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");


    }
}
