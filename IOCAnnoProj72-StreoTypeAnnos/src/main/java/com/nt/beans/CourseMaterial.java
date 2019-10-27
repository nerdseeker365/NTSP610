package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("cm")
public class CourseMaterial {
	@Value("spring part1")
	private String bookName;
	@Value("369")
	private  int pagesCount;
	
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}
	@Override
	public String toString() {
		return "CourseMaterial [bookName=" + bookName + ", pagesCount=" + pagesCount + "]";
	}
	
	

}
