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
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("addBook")) {
            System.out.println("记录增加图书的日志");
        }
        methodProxy.invokeSuper(obj, args);
        return null;
    }
}