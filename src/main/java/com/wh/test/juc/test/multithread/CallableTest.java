package com.wh.test.juc.test.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**callable实现
 * 创建线程的三种方式：
 继承Thread，重写run方法
 实现Runnable接口，重新run方法
 实现Callable接口，重写call方法      提供一个返回值   可以抛出异常
 */
public class CallableTest implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "hello callabel";
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //Future接收callable接口的返回值
        Future<String> future = executorService.submit(new CallableTest());
        System.out.println(future.get());
        executorService.shutdown();
    }
}
