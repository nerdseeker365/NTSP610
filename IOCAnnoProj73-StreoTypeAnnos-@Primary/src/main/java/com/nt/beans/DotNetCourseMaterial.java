package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dncm")
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
