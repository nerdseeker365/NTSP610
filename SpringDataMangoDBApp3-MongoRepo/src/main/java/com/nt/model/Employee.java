package com.nt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="Employee")
@Data
public class Employee {
	@Id
	private int eno;
	private String ename;
	private String desg;
	private  float salary;
}
