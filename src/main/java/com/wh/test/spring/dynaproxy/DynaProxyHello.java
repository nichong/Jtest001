/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DynaProxyHello
 * Author:   wh
 * Date:     2019/2/25 22:06
 * Description: 代理对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈代理对象〉
 */
public class DynaProxyHello implements InvocationHandler {
    /**
     * 操作者
     */
    private Object proxy;
    /**
     * 要处理的对象(也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello)
     */
    private Object delegate;

    /**
     * 动态生成方法别处理过后的对象（写法固定）
     */
    public Object bind(Object delegate, Object proxy) {
        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
                this.delegate.getClass().getInterfaces(),
                this);
    }

    /**
     * 要处理的对象中的每个方法会被此方法送去JVM 调用，也就是说，要处理的对象的方法只能通过此方法调用
     * 此方法是动态的，不是手动调用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = "";
        try {
            //反射得到操作者的实例
            Class clazz = this.proxy.getClass();
            //反射得到操作者的start方法
            Method startM = clazz.getDeclaredMethod("start", new Class[]{Method.class});
            //反射执行start方法
            startM.invoke(this.proxy, new Object[]{method});

            //执行要处理对象的原本方法
            result = method.invoke(this.delegate, args);

            //反射得到操作者的end方法
            Method end = clazz.getDeclaredMethod("end", new Class[]{Method.class});
            //反射执行end方法
            end.invoke(this.proxy, new Object[]{method});
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}