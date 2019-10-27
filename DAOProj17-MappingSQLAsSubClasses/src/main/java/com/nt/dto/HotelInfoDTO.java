package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class HotelInfoDTO implements Serializable {
	private int hno;
	private String hname;
	private String location;
	private  String type;
	private int rating;
	private  float costfor2;
	
	

}
