package com.nt.beans;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PersonDetails {
	private String name;
	private  int age;
	private  float height;
	private  File photoPath;
	private  Date dob;
	private  char gender;
	private byte[] subjectsCount;
	private String[] verifiers;
	private URL  linkedUrl;
	private URI  fbUrl;
	private  char[] grades;
	private  int[] horoScopeNumbers;
	
	
		
	

}
