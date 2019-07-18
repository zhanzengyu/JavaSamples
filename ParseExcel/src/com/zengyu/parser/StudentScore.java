package com.zengyu.parser;

public class StudentScore implements Comparable<StudentScore>{
	
	private String name;
	private int score;
	
	public StudentScore(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "StudentScore [name=" + name + ", score=" + score + "]";
	}
	
	@Override
	public int compareTo(StudentScore o) {
		return o.score - this.score;
	}
	
}
