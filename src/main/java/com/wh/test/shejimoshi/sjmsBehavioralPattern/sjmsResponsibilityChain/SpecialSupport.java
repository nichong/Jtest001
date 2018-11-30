package com.wh.test.shejimoshi.sjmsBehavioralPattern.sjmsResponsibilityChain;

/**
 * 解决特定值
 */
public class SpecialSupport extends Support{
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    /**
     * 解决特定值
     * @param trouble
     * @return
     */
    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number)
            return true;
        return false;
    }
}
