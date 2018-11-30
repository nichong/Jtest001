package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsResponsibilityChain;

public class Main {
    public static void main(String[] args){
        Support noSupport = new NoSupport("noSupport");
        Support limitSupport100 = new LimitSupport("limitSupport100", 100);
        Support limitSupport200 = new LimitSupport("limitSupport200", 200);
        Support limitSupport300 = new LimitSupport("limitSupport300", 300);
        Support specialSupport = new SpecialSupport("specialSupport", 429);
        Support oddSupport    = new OddSupport("oddSupport");

        //连接好责任链
        noSupport.setNext(limitSupport100).setNext(specialSupport).setNext(oddSupport)
                .setNext(limitSupport200).setNext(limitSupport300);

        for (int i = 0; i < 600; i+=33) {
            noSupport.support(new Trouble(i));
        }

        //noSupport.support(new Trouble(900));

    }
}
