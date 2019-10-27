package com.nt.beans;

import java.util.Set;

import lombok.Data;

@Data
public class Tourist {
	private int touristId;
	private  String name;
	private String packageName;
	private  String[] membersName;
	private   Set<String> optedPlaces;
	private   float price;
	private   float finalPrice;
	private   boolean offerAvaiable;
	private  String tourMode;
	

}
