package com.nt.test;

public class ClazzTest {

	public static void main(String[] args) throws Exception{
		Class c1=Class.forName("java.util.Date");
		System.out.println("c1 class name::"+c1.getClass()+" c1 data::"+c1.toString());
		System.out.println("........................................");
		Class c2=Integer.class;
		System.out.println("c2 class name::"+c2.getClass()+" c2 data::"+c2.toString());
		System.out.println(".........................................");
		String s1=new String("ok");
		Class c3=s1.getClass();
		System.out.println("c3 class name::"+c3.getClass()+" c3 data::"+c3.toString());
		System.out.println(".........................................");
	}

}
