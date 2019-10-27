package com.nt.model;

import java.sql.Date;

import lombok.Data;

@Data
public class OExamResult {
	private int id;
	private  Date dob;
	private  float percentage;
	private  int semester;
	

}
