package com.nt.beans;

public class Printer{
	private static  Printer instance=null;
	private Printer() {
		System.out.println("Printer:0-param constructor");
	}
	public static  Printer getInstance() {
		if(instance==null)
			instance=new Printer();
		return instance;
	}
	
	public  void print(String msg) {
		System.out.println(msg);
	}
	

}
