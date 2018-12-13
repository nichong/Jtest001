package com.wh.test.juc.test.blockingQueue;

import java.util.Collection;
import java.util.concurrent.*;

/**BlockingQueue 接口的6个实现
 *
 * ArrayBlockingQueue
 DelayQueue
 LinkedBlockingQueue
 PriorityBlockingQueue
 SynchronousQueue
 */
public class BlockingQueue001 {
    public static void main(String[] args) throws Exception {
        //1.ArrayBolckQueue
  /*      BlockingQueue queue = new ArrayBlockingQueue(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);*/

        //2.延迟队列
/*        DelayQueue delayQueue = new DelayQueue();
        Delayed  element1 = new DelayElement("name");
        delayQueue.put(element1);
        Delayed  element2 = (DelayElement) delayQueue.take();
        System.out.println(element2.getDelay(TimeUnit.SECONDS));*/

        //3.链阻塞队列 LinkedBlockingQueue   单向链表实现的阻塞队列
        //BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);
        bounded.put("Value1");
        bounded.put("Value2");
        bounded.put("Value3");
        String value = bounded.take();
        System.out.println(value);

        //优先级队列
/*        BlockingQueue queue   = new PriorityBlockingQueue();
        PriorityElement e1 = new PriorityElement(3);
        PriorityElement e2 = new PriorityElement(1);
        PriorityElement e3 = new PriorityElement(45);
        PriorityElement e4 = new PriorityElement(33);
        queue.put(e1);
        queue.put(e2);
        System.out.println(queue.drainTo());
        queue.put(e3);
        System.out.println(queue.drainTo());
        queue.put(e4);
        System.out.println(queue.size());
        System.out.println(((PriorityElement)queue.take()).toString());
        System.out.println(((PriorityElement)queue.take()).toString());
        System.out.println(((PriorityElement)queue.take()).toString());
        System.out.println(((PriorityElement)queue.take()).toString());*/

//同步队列 SynchronousQueue
/*        BlockingQueue sq = new SynchronousQueue(true);
        //sq.add("1");
        System.out.println(sq.size());
        System.out.println(sq.remove());
        sq.put("2");
        System.out.println(sq.size());
        System.out.println(sq.peek());

    }*/


    }

    static class Producer implements Runnable {
        private BlockingQueue blockingQueue = null;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public void run() {
            try {
                blockingQueue.add("1");
                Thread.sleep(4000);
                blockingQueue.add("2");
                Thread.sleep(4000);
                blockingQueue.add("3");
                Thread.sleep(4000);
                blockingQueue.add("4");
                Thread.sleep(4000);
            } catch (Exception e) {

            }
        }
    }

   static class Consumer implements Runnable {

        protected BlockingQueue queue = null;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                //poll 获取并移除此队列的头，如果此队列为空，则返回 null
                System.out.println(queue.poll(2, TimeUnit.SECONDS));
                System.out.println(queue.poll(2, TimeUnit.SECONDS));
                System.out.println(queue.poll(2, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //延迟队列
   static class DelayElement implements Delayed {
        private String name;

        public long getDelay(TimeUnit unit) {
            return 1;
        }

        public int compareTo(Delayed o) {
            return 0;
        }

        public DelayElement(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //优先级队列
    class PriorityElement implements Comparable<PriorityElement> {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int compareTo(PriorityElement o) {
            if (this.age > o.age) {
                System.out.println(this.age + "," + o.age + ",comapre" + 1);
                return 1;
            } else {
                System.out.println(this.age + "," + o.age + ",comapre" + 0);
                return 0;
            }
        }

        public PriorityElement(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "PriorityElement{" +
                    "age=" + age +
                    '}';
        }
    }
}
