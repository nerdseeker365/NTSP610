package com.nt.command;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserCommand {
    @Length(min=4,max=10,message="username should have min 4 chars and max 10 chars")
	@NotEmpty(message="username can not be blank")
    private String user;
    private  String country;
    private String[] hobies;
	
	@NotEmpty(message="password can not be blank")
	private String pwd;
	public UserCommand() {
		System.out.println("UserCommand::0-param construtor");
	}

}
