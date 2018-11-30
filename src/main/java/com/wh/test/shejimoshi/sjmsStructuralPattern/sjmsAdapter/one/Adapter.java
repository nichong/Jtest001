package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsAdapter.one;

/**类的适配器模式（采用继承实现）
 *
 * 适配器类，继承了被适配类，同时实现标准接口
 * @author weiH
 *
 * 优点：通过适配器，客户端可以调用同一接口，因而对客户端来说是透明的。但实际这个接口有不同的实现
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //被适配类具有 特殊功能
        super.specificRequest();
    }
}
