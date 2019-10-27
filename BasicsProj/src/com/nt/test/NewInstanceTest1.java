package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceTest1 {

	public static void main(String[] args)throws Exception {
		 Class c=null;
		 Object obj=null;
		 Constructor cons[]=null;
		//Load class at runtime
		 c=Class.forName(args[0]);
		 //get All constructors of the Loaded class
		 cons=c.getDeclaredConstructors();
		 //create Object for Loaded class
		 obj=cons[0].newInstance(10,20);
		 System.out.println("hashCode::"+obj.hashCode());
		 System.out.println("obj class name::"+obj.getClass());
		

	}

}
