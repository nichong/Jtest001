package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsAdapter.two;

/**类的适配器模式（采用继承实现）
 *
 * 适配器类，继承了被适配类，同时实现标准接口
 * @author weiH
 */
public class Adapter implements Target {
    //直接关联
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        //适配功能
        this.adaptee.specificRequest();
    }
}
