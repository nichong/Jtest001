package com.wh.test.shejimoshi.sjmsCreatePattern.sjmsSingleton;
/**单例模式
 * https://blog.csdn.net/qazwsxpcm/article/details/80950612
 * 1.构造方法私有化（private）;
 *2.定义一个私有(private)静态(static)实例化对象;
 *3.对外提供一个公共(public)静态(static)的方法得到该实例;
 */


/**
 *饿汉式
 * 优点：写起来很简单，并且不会因为不加synchronized关键字而造成的线程不安全问题。
 *缺点：当该类被加载的时候，会初始化该实例和静态变量并被创建并分配内存空间，并且会一直占用内存。
 * @author weiH
 */
public class SingletonTest1 {
    private SingletonTest1(){}
    private static final SingletonTest1 instance = new SingletonTest1();
    public static SingletonTest1 getInstance(){
        return instance;
    }
}

/**
 * 饱汉式
 * 优点：写起来很简单，在第一次调用的时候才会初始化，节省了内存。
 * 缺点：线程不安全，多个线程调用可能会出现多个实例。
 * 总结：书写简单，线程不安全，效率还行。
 */
class SingletonTest2 {
    private SingletonTest2() {
    }
    private static SingletonTest2 instance;
    public static SingletonTest2 getInstance() {
        if (instance == null) {
            instance = new SingletonTest2();
        }
        return instance;
    }
}

/**
 * 静态内部类
 */
class  SingletonTest4 {
    private SingletonTest4(){
    }
    private static class SingletonTest5{
        private static SingletonTest4 instance = new SingletonTest4();
    }
    public static final SingletonTest4 getInstance(){
        return SingletonTest5.instance;
    }
}

/**
 * 双重锁检查
 */
class SingletonTest6 {
    private SingletonTest6() {
    }
    //volatile可见性
    private static volatile SingletonTest6 instance;
    public static SingletonTest6 getIstance() {
        if (instance == null) {
            synchronized (SingletonTest6.class) {
                if (instance == null) {
                    instance = new SingletonTest6();
                }
            }
        }
        return instance;
    }
}

/**
 * 枚举单例
 */
enum SingletonTest7{
    INSTANCE;
}

