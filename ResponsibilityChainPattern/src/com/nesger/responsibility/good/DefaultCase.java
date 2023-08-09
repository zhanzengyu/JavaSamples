package com.nesger.responsibility.good;

public class DefaultCase extends BaseCase {
    public DefaultCase(boolean isConsume) {
        super(isConsume);
    }

    @Override
    protected void doSomething() {
    		//TODO do something
		System.out.println(getClass().getName());
    }
}
