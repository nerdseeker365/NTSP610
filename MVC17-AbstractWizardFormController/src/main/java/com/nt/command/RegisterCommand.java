package com.nt.command;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name;
	private String email;
	private String addrs;
	private String domain;
	private  int experience;
	private  int expectedSalary;
	private  String prefferedLocation;
	
	public RegisterCommand() {
		System.out.println("RegisterCommand::0-param constructor");
	}

}
