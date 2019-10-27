package com.nt.beans;

import java.beans.ConstructorProperties;

public class AccountHolder {
	private int acno;
	private String name;
	private String branch;
	private float balance;
	private  long bankCode;
	//@ConstructorProperties(value={"no","name","branch","balance","bankCode"})
	public AccountHolder(int no, String name, String branch, float balance, long bankCode) {
		System.out.println("AccountHolder.5-param constructor");
		this.acno = no;
		this.name = name;
		this.branch = branch;
		this.balance = balance;
		this.bankCode = bankCode;
	}
	@Override
	public String toString() {
		return "AccountHolder [acno=" + acno + ", name=" + name + ", branch=" + branch + ", balance=" + balance
				+ ", bankCode=" + bankCode + "]";
	}
	
	

}
