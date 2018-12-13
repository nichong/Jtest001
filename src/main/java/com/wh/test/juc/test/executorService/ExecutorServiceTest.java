package com.wh.test.juc.test.executorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * 拒绝策略介绍:
 * AbortPolicy         -- 当任务添加到线程池中被拒绝时，它将抛出 RejectedExecutionException 异常。
 CallerRunsPolicy    -- 当任务添加到线程池中被拒绝时，会在线程池当前正在运行的Thread线程池中处理被拒绝的任务。
 DiscardOldestPolicy -- 当任务添加到线程池中被拒绝时，线程池会放弃等待队列中最旧的未处理任务，然后将被拒绝的任务添加到等待队列中。
 DiscardPolicy       -- 当任务添加到线程池中被拒绝时，线程池将丢弃被拒绝的任务
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1，"线程池"的阻塞队列容量为1。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        //设置拒绝策略
        /**
         * 依次将任务1.2.3加入线程池，如果分别采用如下策略，有以下结果：
         * AbortPolicy   抛出RejectedExecutionException异常
         * CallerRunsPolicy   3,1,2     拒绝3的时候，1在运行，2在等待队列。所以使用
         * DiscardOldestPolicy  1，3    丢弃等待队列中的任务2，将拒绝的任务3加入等待对列中
         * DiscardOldestPolicy  1,2     丢弃被拒绝的任务3
         */
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //添加三个任务
        threadPoolExecutor.execute(new Rt("1"));
        threadPoolExecutor.execute(new Rt("2"));
        threadPoolExecutor.execute(new Rt("3"));

        threadPoolExecutor.shutdown();

    }
}

/**
 * 任务线程
 */
class Rt implements Runnable{
    private String name;

    public Rt(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }
}

