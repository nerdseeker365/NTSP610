package com.nt.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nt.adapter.SqlDateAdapter;

@XmlRootElement(name = "ExamResult")
public class ExamResult {
	private int id;
	private  Date dob;
	private  float percentage;
	private int sem;
	@XmlElement(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="dob")
	@XmlJavaTypeAdapter(type=java.sql.Date.class,value=SqlDateAdapter.class)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@XmlElement(name="percentage")
	public float getPercentage() {
		return percentage;
	}
	
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	@XmlElement(name="sem")
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	

}
