package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterCommand {
	private  int empNo;
	private String  empName;
	private  Date dob,doj,dom;

}
