package com.nesger.responsibility.good;

public class OneCase extends BaseCase {

	public OneCase(boolean isConsume) {
		super(isConsume);
	}

	@Override
	protected void doSomething() {
		// TODO do something
		System.out.println(getClass().getName());
	}
}
