package com.nt.singleton;

public class Printer {
	private static  Printer instance;
	
	private Printer(){
		System.out.println("Printer::0-param constructor(private)");
	}
	//static factory method
	public static Printer getInstance() {
		if(instance==null)
			instance=new Printer();
		return instance;
	}
	
	public void print(String msg) {
		System.out.println(msg);
	}
	

}
