/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Main
 * Author:   wh
 * Date:     2019/2/25 22:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.dynaproxy;

/**
 * 动态代理只能代理接口类
 *
 * 性能影响，因为动态代理是使用反射机制实现的，首先反射肯定比直接调用要慢，
 * 其次使用反射大量生成类文件可能引起full gc，因为字节码文件加载后会存放在JVM运行时方法区（或者叫永久代、元空间）中，当方法区满时会引起full gc，所以当你大量使用动态代理时，可以将永久代设置大一些，减少full gc的次数

 */
public class Main {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello().bind(new Hello(), new LoggerOperation());
        hello.sayGoogBye("Bob");
        hello.sayHello("Tom");
    }
}