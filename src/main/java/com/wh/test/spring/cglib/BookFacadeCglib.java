/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookFacadeCglib
 * Author:   wh
 * Date:     2019/2/25 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.cglib;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 * cglib代理原理：CGLib采用非常底层的字节码技术，可以为一个类创建子类，并在子类中采用方法拦截的技术拦截所有的父类方法的调用，并顺势织入横切逻辑。
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());//设置需要创建子类的类
        //回调方法
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    //回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("log-------------" + method.getName());
        //通过代理类调用父类中的方法
        methodProxy.invokeSuper(obj, args);
        return null;
    }
}