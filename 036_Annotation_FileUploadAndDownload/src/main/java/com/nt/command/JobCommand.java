package com.nt.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class JobCommand {
	private String name;
	private String address;
	private MultipartFile photo;
	private MultipartFile resume;
	
	public JobCommand() {
		System.out.println("JobCommand.JobCommand()");
	}
}