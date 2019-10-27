package com.nt.beans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Named("stud")
public class Student {
	@Value("${id}")
	private int id;
	@Inject
	private CourseMaterial material;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", material=" + material + "]";
	}
	
	
	
	

}
