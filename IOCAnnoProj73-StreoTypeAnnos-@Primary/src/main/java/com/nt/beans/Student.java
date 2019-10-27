package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("stud")
public class Student {
	@Value("1001")
	private int id;
	
     @Autowired(required=true)
     @Qualifier("jcm")
	private  CourseMaterial material;
     
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", material=" + material + "]";
	}

	
}
