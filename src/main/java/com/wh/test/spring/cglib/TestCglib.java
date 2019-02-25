/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestCglib
 * Author:   wh
 * Date:     2019/2/25 22:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.cglib;
/**
 * 测试cglib字节码代理
 *
 * AOP与JAVA动态代理    https://www.cnblogs.com/xiaoxiao7/p/6057724.html
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookFacade.addBook();
        bookFacade.deleteBook();
    }
}