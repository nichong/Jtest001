package com.wh.test.juc.test.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch所描述的是”在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待
 * 解释：每当一个线程完成自己的任务后，计数器的值就会减1。当计数器的值变为0时，就表示所有的线程均已经完成了任务，然后就可以恢复等待的线程继续执行了。
 * 场景：老板进入会议室等待5个人全部到达会议室才会开会。所以这里有两个线程老板等待开会线程、员工到达会议室
 */
public class CountDownLatchTest {
    private  static CountDownLatch countDownLatch = new CountDownLatch(5);

    static class BossThread implements Runnable{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共需要有" + countDownLatch.getCount() + "个人开会...");
            try {
                //阻塞BossThread等待，当countDownLatch为0时，唤醒
                countDownLatch.await();
                //countDownLatch.await(1L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boss说：人到齐了，开会吧");
        }
    }

    static class EmpleoyeeThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ ",到达会议室");
            // 员工到达会议室 count - 1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args){
        new Thread(new BossThread()).start();

        long count = countDownLatch.getCount();
        for (int i = 0; i < count; i++){
            new Thread(new EmpleoyeeThread()).start();
        }
    }
}
