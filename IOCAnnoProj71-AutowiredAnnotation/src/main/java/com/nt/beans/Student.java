package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	private int id;
	
     @Autowired(required=true)
    // @Qualifier("cm1")
    @Qualifier("bk2")
	private CourseMaterial material;
     
	public void setId(int id) {
		this.id = id;
	}
	
	@Autowired
	@Qualifier("bk1")
	public void setMaterial(CourseMaterial material) {
		System.out.println("setMaterial(-)");
		this.material=material;
	}
	
	@Autowired
	//@Qualifier("bk1") not possible
	public Student(CourseMaterial material) {
		System.out.println("Student.Student()");
		this.material=material;
	}
	
	

	
	@Autowired
	@Qualifier("bk2")
	public void assign(CourseMaterial material) {
		System.out.println("Student.assign()");
		this.material=material;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", material=" + material + "]";
	}

	
}
