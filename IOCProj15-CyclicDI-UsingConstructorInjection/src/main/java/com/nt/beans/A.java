package com.nt.beans;

public class A {
	private B b;
	public A(B b) {
		this.b=b;
		System.out.println("A:1-param cosntructor");
	}

	//toString
	@Override
	public String toString() {
		return "A [b=";
	}
	

}