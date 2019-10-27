package com.nt.beans;

public class Student {
	private int sno;
	private String sname;
	private String addrs;
	private String course;
	public Student(int sno, String sname, String addrs, String course) {
		System.out.println("Student:4-param constructor");
		this.sno = sno;
		this.sname = sname;
		this.addrs = addrs;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", addrs=" + addrs + ", course=" + course + "]";
	}
	
	
	

}
