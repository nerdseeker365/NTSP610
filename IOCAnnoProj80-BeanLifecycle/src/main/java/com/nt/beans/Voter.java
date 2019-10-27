package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named("voter")
public class Voter {
	@Value("raja")
	private  String name;
	//@Value("30")
	private int age;
	private Date checkedDate;
	
	@PostConstruct
	public void myInit() {
		System.out.println("Voter::myInit()");
		if(age<=0)
			throw new IllegalArgumentException("invalid inputs");
		//initialiation 
		checkedDate=new Date();
	}
	
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Voter: myDestroy()");
		name=null;
		age=0;
		checkedDate=null;
	}
	
	//b.method/service method
	public  String  checkVotingEligiblity() {
		if(age<18)
			return  "Mr./Miss/Mrs. "+name+ " u  r not elgible to vote ,verified on"+checkedDate;
		else
			return  "Mr./Miss/Mrs. "+name+ " u  r  elgible to vote ,verified on"+checkedDate;
	}

}
