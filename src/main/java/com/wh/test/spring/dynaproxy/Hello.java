/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Hello
 * Author:   wh
 * Date:     2019/2/25 22:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.dynaproxy;

public class Hello implements IHello {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye!");
    }
}
