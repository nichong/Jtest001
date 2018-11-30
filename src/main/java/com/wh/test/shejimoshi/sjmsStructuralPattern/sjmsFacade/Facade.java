package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsFacade;

/**外观模式（门面模式）
 *
 * https://blog.csdn.net/jason0539/article/details/22775311
 * Facade类其实相当于A、B、C模块的外观界面，有了这个Facade类，那么客户端就不需要亲自调用子系统中的A、B、C模块了，
 * 也不需要知道系统内部的实现细节，甚至都不需要知道A、B、C模块的存在，客户端只需要跟Facade类交互就好了，
 * 从而更好地实现了客户端和子系统中A、B、C模块的解耦，让客户端更容易地使用系统。
 *
 * 场景模拟：
 * 病人去医院看病
 * 问题抛出：病人需要访问 挂号、门诊、划价、化验、收费、取药等各个部门（太麻烦，病人都弄晕了）
 * 解决：医院可以设置一个接待员的位置，由接待员负责代为挂号、划价、缴费、取药等。这个接待员就是门面模式的体现，病人只接触接待员，由接待员与各个部门打交道。
 * @author weiH
 *
 * Facade门面（接待员） 作用：
 * 1.做中间桥梁，屏蔽了病人和各个部门中间的访问
 * 2.一个系统可以有几个门面类：比如设置另个Facade类去集成不同的Modulel类方法
 * 3.有选择性地暴露方法：ModuleAl类中的方法testA1（） testA2（） testA3（）不提供出来。
 */
public class Facade {
    //示意方法，满足客户端需要的功能
    public void test(){
        ModuleA a = new ModuleA();
        ModuleB b = new ModuleB();
        ModuleC c = new ModuleC();
        a.testA();
        b.testB();
        c.testC();
    }
}
