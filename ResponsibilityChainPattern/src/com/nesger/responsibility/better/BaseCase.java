package com.nesger.responsibility.better;

interface BaseCase {
	// 所有 case 处理逻辑的方法
	void doSomething(String input, BaseCase baseCase);
}
