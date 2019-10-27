package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class UserCommand {
	private String user;
	private String pwd;
	private  Date dob;
	public UserCommand() {
		System.out.println("UserCommand::0-param construtor");
	}

}
