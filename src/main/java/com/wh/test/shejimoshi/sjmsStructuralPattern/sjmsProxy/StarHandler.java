package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//JDK动态代理（通过程序动态生成代理类，该代理类不是我们自己定义的。而是由程序自动生成）
//特点：只能对实现了接口的类生产代理，不能针对类
/**
 * 处理器
 */
public class StarHandler implements InvocationHandler {
    private Star realStar;//真实角色
    /**
     * 所有的流程控制都在invoke方法中
     * proxy：代理类
     * method：正在调用的方法
     * args：方法的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真实角色调用之前的处理.....");
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar, args);//激活调用的方法
        }
        System.out.println("真实角色调用之后的处理.....");
        return object;
    }
    //通过构造器来初始化真实角色
    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }

    public static void main(String[] args) {
        //真实角色
        Star realStar = new RealStar();
        //处理器
        StarHandler handler = new StarHandler(realStar);
        //代理类
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.sing();//调用代理类的唱歌方法：其实调用的是真实角色的唱歌方法
    }
}
