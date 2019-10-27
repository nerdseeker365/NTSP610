package com.nt.test;

import java.lang.reflect.Constructor;

class Test{
	 private  Test() {
		System.out.println("Test:0-param constructor");
	}

	@Override
	public String toString() {
		return "Test [toString()=" + super.toString() + "]";
	}
	 
 }


public class EncapsulationTest {

	public static void main(String[] args) {
	     //  Test t=new Test();
		Constructor cons[]=null;
		try {
		//Load class
		Class c=Class.forName("com.nt.test.Test");
		//get Access to All constructor of the class
		cons=c.getDeclaredConstructors();
		//get Access to private constructor
		cons[0].setAccessible(true);
		//create object
		Test t=(Test)cons[0].newInstance();
		System.out.println("t obj hashCode::"+t.hashCode());
		
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
