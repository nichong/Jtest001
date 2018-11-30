package com.wh.test.juc.test.volite;

public class TestVolatile {
    public static void main(String[] args){
        Demo d = new Demo();
        new Thread(d).start();
        System.out.println("in main:" +d.isFlag());

            while (true){
                if(d.isFlag()){
                    System.out.println("+++++++++++++++："+ d.isFlag());
                    break;
                }
            }
        }
}

class Demo implements Runnable{
    //当使用volatile时，Demo线程修改flag为true后，main线程可以见，就可以退出循环
    //volatile 不具备"互斥性"、"原子性";
    //互斥性，就是一个线程持有锁，另外线程则必须等待
    private  volatile boolean flag = false;

    //private  boolean flag = false;

    public  boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("in Demo class:"+flag);
    }
}


