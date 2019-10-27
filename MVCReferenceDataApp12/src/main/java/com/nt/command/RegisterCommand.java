package com.nt.command;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name="raja";
	private String addrs="vizag";
	private  String gender="male";
	private String hobies[]=new String[] {"eating","Sleeping"};
	private String country="---select---";
	private  String  courses[]=new String[] {"bored to study"};

}
