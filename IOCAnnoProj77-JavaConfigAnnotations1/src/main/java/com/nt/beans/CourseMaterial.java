package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Named("cm")
public class CourseMaterial {
	@Value("${bkName}")
	private  String bookName;
	@Value("${pCount}")
	private int  pagesCount;
	
	
	@Override
	public String toString() {
		return "CourseMaterial [bookName=" + bookName + ", pagesCount=" + pagesCount + "]";
	}
	
	

}
