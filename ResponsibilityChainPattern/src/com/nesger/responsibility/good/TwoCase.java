package com.nesger.responsibility.good;

public class TwoCase extends BaseCase {

    public TwoCase(boolean isConsume) {
        super(isConsume);
    }

    @Override
    protected void doSomething() {
        //TODO do something
    		System.out.println(getClass().getName());
    }
}
