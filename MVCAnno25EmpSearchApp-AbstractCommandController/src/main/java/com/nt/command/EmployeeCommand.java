package com.nt.command;

import lombok.Data;

@Data
public class EmployeeCommand {
	private int empNo;
	private String ename;
	private String job;
	private float sal;
	
	public  EmployeeCommand() {
		System.out.println("EmployeeCommand :: 0-param constructor");
	}

}
