package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("jcm")
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
