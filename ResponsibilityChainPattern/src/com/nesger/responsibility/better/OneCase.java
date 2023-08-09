package com.nesger.responsibility.better;

public class OneCase implements BaseCase {
	@Override
	public void doSomething(String input, BaseCase baseCase) {
		if ("1".equals(input)) {
			// TODO do something
			System.out.println(getClass().getName());
			return;
		}
		//当前没法处理，回调回去，让下一个去处理
		baseCase.doSomething(input, baseCase);
	}
}
