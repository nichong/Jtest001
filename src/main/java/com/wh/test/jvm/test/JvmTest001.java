package com.wh.test.jvm.test;

import java.util.ArrayList;
import java.util.List;

public class JvmTest001 {
    public static void main(String[] args) {
        System.out.println("最大堆："+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆："+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("总的堆："+Runtime.getRuntime().totalMemory()/1024/1024+"M");

        //栈溢出测试
        //stackOverflowTest();
        //堆溢出测试
        //heapOverflowTest();

    }

    /**
     * 测试内容：栈溢出测试（递归调用导致栈深度不断增加）
     * 虚拟机参数：-Xss128k
     */
    public static void stackOverflowTest(){
        stackOverflowTest();
    }

    /**
     * 测试内容：堆溢出
     *
     * 虚拟机参数：-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
     * 输出： java.lang.OutOfMemoryError: Java heap space
     */
    public static void heapOverflowTest(){
        List<JvmTest001> list = new ArrayList<JvmTest001>();
        while (true) {
            list.add(new JvmTest001());
        }
    }
}
