package com.nt.beans;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import lombok.Setter;
import lombok.ToString;

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
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setPhotoPath(File photoPath) {
		this.photoPath = photoPath;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setSubjectsCount(byte[] subjectsCount) {
		this.subjectsCount = subjectsCount;
	}
	public void setVerifiers(String[] verifiers) {
		this.verifiers = verifiers;
	}
	public void setLinkedUrl(URL linkedUrl) {
		this.linkedUrl = linkedUrl;
	}
	public void setFbUrl(URI fbUrl) {
		this.fbUrl = fbUrl;
	}
	public void setGrades(char[] grades) {
		this.grades = grades;
	}
	public void setHoroScopeNumbers(int[] horoScopeNumbers) {
		this.horoScopeNumbers = horoScopeNumbers;
	}
	@Override
	public String toString() {
		return "PersonDetails [name=" + name + ", age=" + age + ", height=" + height + ", photoPath=" + photoPath
				+ ", dob=" + dob + ", gender=" + gender + ", subjectsCount=" + Arrays.toString(subjectsCount)
				+ ", verifiers=" + Arrays.toString(verifiers) + ", linkedUrl=" + linkedUrl + ", fbUrl=" + fbUrl
				+ ", grades=" + Arrays.toString(grades) + ", horoScopeNumbers=" + Arrays.toString(horoScopeNumbers)
				+ "]";
	}
	
	
		
	

}
