package com.wh.test.juc.test.cas;

public class TestCompareAndSwap{
    public static void main(String[] args){
        final CompareAndSwap cas = new CompareAndSwap();

        for(int i=0; i<10; i++){
            // 创建10个线程,模拟多线程环境
            new Thread(new Runnable(){
                @Override
                public void run(){
                    int expectedValue = cas.get();
                    int newValue = (int)(Math.random()*100);

                    boolean b = cas.compareAndSet(expectedValue, newValue);
                    System.out.println(b);
                }
            }).start();
        }
    }
}