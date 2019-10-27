package com.nt.command;

import lombok.Data;

@Data
public class CustomerCommand {
	private Integer cno;
	private String cname;
	private String  cadd;
	private Long   mobileNo;
	private  Float billAmt;

}
