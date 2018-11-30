package com.wh.test.shejimoshi.sjmsStructuralPattern.sjmsProxy;

//静态代理（静态定义代理类，我们自己静态定义的代理类。比如我们自己定义一个明星的经纪人类ProxyStar）
//经济人
public class ProxyStar implements Star {
    private Star star;//真实对象的引用（明星）
    public ProxyStar(Star star){
        this.star = star;
    }
    public void confer() {
        System.out.println("经济人代表明星去面谈");
    }

    public void sing() {
        //调用明星唱歌方法
        star.sing();
    }

    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.sing();//真实对象的操作（明星唱歌）
    }
}
