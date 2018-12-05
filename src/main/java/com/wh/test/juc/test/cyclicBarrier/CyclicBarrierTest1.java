package com.wh.test.juc.test.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier允许一组线程互相等待，直到到达某个公共屏障点
 */
public class CyclicBarrierTest1 {

    private static int SIZE = 5;
    private static CyclicBarrier cb;
    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE);

        // 新建5个任务(任务数 == CyclicBarrier初始化给的size，否则无法停止)
        for(int i=0; i<SIZE; i++){
            new InnerThread().start();
        }
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();//阻塞当前线程

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
