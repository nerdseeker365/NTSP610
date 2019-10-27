package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;

public class Robot {
	private  int id;
	private String name;
	private Date dob,doe;
	
	@Required
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Required
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	
	@Override
	public String toString() {
		return "Robot [id=" + id + ", name=" + name + ", dob=" + dob + ", doe=" + doe + "]";
	}
	
	

}
