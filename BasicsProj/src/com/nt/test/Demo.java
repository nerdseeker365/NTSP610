package com.nt.test;

public class Demo {
	static {
		System.out.println("Demo:static block");
	}
	/*public Demo() {
		System.out.println("Demo:0-param construtor");
	}*/
	public  Demo(int x,int y) {
		System.out.println("Demo:2-param constructor");
	}

}
