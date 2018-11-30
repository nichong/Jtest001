package com.wh.test.juc.test.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args){
        ReadWriteLockTest rt = new ReadWriteLockTest();

        //一个线程写
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rt.write((int) (Math.random() * 100));
                }
            }, "write"+(i+1)).start();
        }

        //多个线程读数据
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rt.read();
                }
            }, "read"+(i+1)).start();
        }
    }

    static class  ReadWriteLockTest{
        private int number = 0;
        /**
  　　   *ReentrantReadWriteLock支持以下功能：
 　　　　*1）支持公平和非公平的获取锁的方式；
 　　　　*2）支持可重入。读线程在获取了读锁后还可以获取读锁；写线程在获取了写锁之后既可以再次获取写锁又可以获取读锁；
 　　　　*3）还允许从写入锁降级为读取锁，其实现方式是：先获取写入锁，然后获取读取锁，最后释放写入锁。但是，从读取锁升级到写入锁是不允许的；
 　　　　*4）读取锁和写入锁都支持锁获取期间的中断；

         *ReentrantReadWriteLock允许多个读线程同时访问，但不允许写线程和读线程、写线程和写线程同时访问
         */
        //读写锁
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        /**
         * 写方法
         * @param number
         */
        public void write(int number){
            //上写锁
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"写入："+ number);
                this.number = number;
            }finally {
                //释放写锁
                lock.writeLock().unlock();
            }
        }

        /**
         * 读数据
         */
        public void read(){
            //上读锁
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"读到数据："+ number);
            }finally {
                //释放度锁
                lock.readLock().unlock();
            }
        }
    }
}
