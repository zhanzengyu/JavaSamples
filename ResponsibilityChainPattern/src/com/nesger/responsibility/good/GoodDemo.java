package com.nesger.responsibility.good;

public class GoodDemo {
	public static void main(String[] args) {
		String input = "1";
		
		OneCase oneCase = new OneCase("1".equals(input));
		TwoCase twoCase = new TwoCase("2".equals(input));
		DefaultCase defaultCase = new DefaultCase(true);
		
		oneCase.setNextCase(twoCase);
		twoCase.setNextCase(defaultCase);
		
		oneCase.handleRequest();
	}
}
