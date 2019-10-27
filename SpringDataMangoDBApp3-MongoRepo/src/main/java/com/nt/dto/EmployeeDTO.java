package com.nt.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int eno;
	private String ename;
	private String desg;
	private  float salary;
}
