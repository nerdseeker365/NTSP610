package com.nt.test;
public class NewInstanceTest {

	public static void main(String[] args)throws Exception {
		 Class c=null;
		 Object obj=null;
		//Load class at runtime
		 c=Class.forName(args[0]);
		 //create Object for Loaded class
		 obj=c.newInstance();
		 System.out.println("hashCode::"+obj.hashCode());
		 System.out.println("obj class name::"+obj.getClass());
		

	}

}
