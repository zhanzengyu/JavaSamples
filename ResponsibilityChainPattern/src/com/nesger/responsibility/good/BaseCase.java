package com.nesger.responsibility.good;

public abstract class BaseCase {
	// 为 true 表明自己可以处理该 case
	private boolean isConsume;

	public BaseCase(boolean isConsume) {
		this.isConsume = isConsume;
	}

	// 下一个责任节点
	private BaseCase nextCase;

	public void setNextCase(BaseCase nextCase) {
		this.nextCase = nextCase;
	}

	public void handleRequest() {
		if (isConsume) {
			// 如果当前节点可以处理，直接处理
			doSomething();
		} else {
			// 如果当前节点不能处理，并且有下个节点，交由下个节点处理
			if (null != nextCase) {
				nextCase.handleRequest();
			}
		}
	}

	abstract protected void doSomething();
}
