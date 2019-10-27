package com.nt.beans;

import java.util.Date;

import javax.inject.Named;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Named("dtdc")
@DependsOn("fpkt")
//@Lazy
public class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC: 0-param constructor");
	}
	
	public void deliver(int oid) {
		System.out.println(oid+" order is delivered to customer on "+new Date()+"by DTDC");
	}

}
