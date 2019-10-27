package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named("dncm")
//@Primary
public class DotNetCourseMaterial implements CourseMaterial {
	@Value("easyC#")
	private String bookName;
	@Value("100")
	private int pagesCount;
	
	
	@Override
	public String toString() {
		return "DotNetCourseMaterial [bookName=" + bookName + ", pagesCount=" + pagesCount + "]";
	}
	
	

}
