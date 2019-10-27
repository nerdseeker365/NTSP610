package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class CourseMaterial {
	private String bookName;
	private  int pagesCount;
	
	@Required
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
