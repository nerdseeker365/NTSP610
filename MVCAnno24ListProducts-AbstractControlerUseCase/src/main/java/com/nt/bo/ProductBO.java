package com.nt.bo;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductBO {
	private int pid;
	private String pname;
	private float price;
	private float stockQty;
	private Date  mfgDate;
	private Date expiryDate;
	

}
