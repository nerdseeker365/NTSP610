package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int eid;
	private String ename;
	private String desg;
	private  float salary;

}
