package com.nt.beans;

import java.util.Date;
import java.util.List;

public class College {
	private List<String> studNames;
	private List<Date>  dateList;
	private List<?>  objList;
	
	public void setObjList(List<?> objList) {
		this.objList = objList;
	}
	public void setStudNames(List<String> studNames) {
		System.out.println(studNames.getClass());
		this.studNames = studNames;
	}
	public void setDateList(List<Date> dateList) {
		System.out.println(dateList.getClass());
		this.dateList = dateList;
	}
	@Override
	public String toString() {
		return "College [studNames=" + studNames + ", dateList=" + dateList + ", objList=" + objList + "]";
	}
	
	
	

}
