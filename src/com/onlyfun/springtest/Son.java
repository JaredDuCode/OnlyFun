package com.onlyfun.springtest;

public class Son extends Father {
	
	void sys(){
		System.out.println("it is son");
	}
	
	public static void main(String[] args) {
		Son s = new Son();
		s.outname();
	}

}
