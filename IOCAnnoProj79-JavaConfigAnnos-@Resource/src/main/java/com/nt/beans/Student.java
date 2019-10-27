package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;



@Named("stud")
public class Student {
	@Value("1001")
	private int id;
	
	@Resource(name="jcm")
   	private  CourseMaterial material;

	/*@Resource(name="jcm")  //DisAllowed here
	  public Student(CourseMaterial material) {
		  this.material=material;
	  }*/
   	
   	/*@Resource(name="jcm")
   	public  void setMaterial(CourseMaterial material ) {
   		System.out.println("Student.setMaterial()");
   		this.material=material;
   	}*/
   	
   	/*@Resource(name="jcm")
   	public  void putMaterial(CourseMaterial material ) {
   		System.out.println("Student.putMaterial()");
   		this.material=material;
   	}*/
   

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", material=" + material + "]";
	}

	
}
