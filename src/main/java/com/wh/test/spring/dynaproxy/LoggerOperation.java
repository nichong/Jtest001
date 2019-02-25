/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoggerOperation
 * Author:   wh
 * Date:     2019/2/25 22:03
 * Description: 日志操作类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wh.test.spring.dynaproxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈日志操作类〉
 *
 * @author wh
 * @create 2019/2/25
 * @since 1.0.0
 */
public class LoggerOperation implements IOperation {
    public void end(Method method) {
        System.out.println(method.getName() + " Method end .");
    }
    public void start(Method method) {
        System.out.println(method.getName() + " Method Start!");
    }
}
