package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int eid;
	private String ename;
	private String desg;
	private  float salary;

}
