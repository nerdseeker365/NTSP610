package com.nt.beans;

import java.util.Date;

public class PersonInfo {
	private long aid;
	private String name;
	private String addrs;
	private Date dob;
	public PersonInfo(long aid, String name, String addrs, Date dob) {
	System.out.println("PersonInfo.PersonInfo(4-param constructor)");
		this.aid = aid;
		this.name = name;
		this.addrs = addrs;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "PersonInfo [aid=" + aid + ", name=" + name + ", addrs=" + addrs + ", dob=" + dob + "]";
	}
	
	
	

}
