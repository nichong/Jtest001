package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsResponsibilityChain;

/**
 * LimitSupport类，解决指定范围内的问题
 */
public class LimitSupport extends Support{
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    /**
     * 只解决比limit小的值问题
     * @param trouble
     * @return
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit)
            return true;
        return false;
    }
}
