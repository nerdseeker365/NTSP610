package com.nt.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class JobDto implements Serializable {
	private String name;
	private String address;
	private String photopath;
	private String resumepath;
	
	
	public JobDto() {
	System.out.println("JobDto.JobDto()");
	}//constructor
}
