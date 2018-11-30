package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsResponsibilityChain;

/**责任链模式
 * 关键代码：Handler 里面聚合它自己，在 HanleRequest 里判断是否合适，如果没达到条件则向下传递，向谁传递之前 set 进去
 * 能做则做，不能做丢锅给下一个
 * Support是一个抽象类，他的核心方法support中，如果当前support可以解决，就解决，如果不行，就交给next去解决。
 */
public abstract class Support {
    private String name;
    private Support next;
public Support(String name){
    this.name = name;
}
    public Support setNext(Support next){
        this.next = next;
        return next;
    }
    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }
    @Override
    public String toString(){
        return "[" + name + "]";
    }
    //是否解决
    protected abstract boolean resolve(Trouble trouble);
    //解决方法（业务逻辑）
    protected void done(Trouble trouble){
        System.out.println(trouble.getNumber() + " :被:"+ this + "解决");
    }
    //未解决
    protected void fail(Trouble trouble){
        System.out.println(trouble.getNumber() + " :未解决");
    }
}
