package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeResultDTO extends EmployeeDTO implements Serializable{
	private int deptNo;
	private  int mgr;
	
	

}
