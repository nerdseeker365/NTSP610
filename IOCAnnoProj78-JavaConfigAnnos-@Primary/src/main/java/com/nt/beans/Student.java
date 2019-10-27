package com.nt.beans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Named("stud")
public class Student {
	@Value("1001")
	private int id;
	
    /* @Inject
     //@Named("jcm")
     @Qualifier("jcm")
*/	private  CourseMaterial material;

   /* @Inject
    @Named("jcm")
     public  Student(CourseMaterial material) {
    	System.out.println("Student:: 1-param constructor");
    	 this.material=material;
     }*/
     
/*@Inject
@Named("jcm")
	public void setMaterial(CourseMaterial material) {
	 System.out.println("Student.setMaterial()");
	this.material = material;
}*/

@Inject
@Named("jcm")
public void R369(CourseMaterial material) {
	 System.out.println("Student::R369()");
	this.material = material;
}


	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", material=" + material + "]";
	}

	
}
