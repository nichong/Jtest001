package com.wh.test.juc.test.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(123);
        int expectedValue = 123;
        int newValue = 234;
        System.out.println(atomicInteger.getAndAdd(10));//123
        System.out.println(atomicInteger.get());//133
        System.out.println(atomicInteger.addAndGet(10));//143
        System.out.println(atomicInteger.get());//143



        Run1 run1 = new Run1();
        new Thread(run1, "1号窗口").start();
        new Thread(run1, "2号窗口").start();
        new Thread(run1, "3号窗口").start();
    }

    static class Run1 implements Runnable {
        //ReentrantLock是一个排他锁，同一时间只允许一个线程访问
        private Lock lock = new ReentrantLock();
        private int tick = 100;

        public void run() {
            while (true) {
                if (tick > 0) {
                    lock.lock();
                    try {
                        int max = 1000;
                        int min = 100;
                        Random random = new Random();
                        int s = random.nextInt(max) % (max - min + 1) + min;

                        System.out.println(Thread.currentThread().getName() + "卖票成功，余票为：" + --tick);
                        Thread.sleep(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }
    }
}
