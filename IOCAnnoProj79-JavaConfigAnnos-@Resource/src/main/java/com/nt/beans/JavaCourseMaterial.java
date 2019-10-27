package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;

@Named("jcm")
//@Primary
public class JavaCourseMaterial implements CourseMaterial {
	@Value("CRJ")
	private String bookName;
	@Value("369")
	private int pagesCount;
	
	
	@Override
	public String toString() {
		return "JavaCourseMaterial [bookName=" + bookName + ", pagesCount=" + pagesCount + "]";
	}
	
	

}
