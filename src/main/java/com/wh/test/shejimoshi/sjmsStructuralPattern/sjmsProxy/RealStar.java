package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsProxy;

/**
 * 真实角色（明星）：
 */
public class RealStar implements Star{
    public void confer() {
        System.out.println("RealStar.confer()");
    }
    public void sing() {
        System.out.println("明星张学友唱歌了");//真实角色的操作：真正的业务逻辑
    }
}
