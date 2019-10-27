package com.nt.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class HolidayPackage {
	private int packageId;
	private String packageName;
	private  Date   date;
	private  List<String> placesAvailable;
	private  Map<String,Integer> placesPrices; 
	private  String[]  treatmentTypes;
	private  int[] durations;
	private  float offerDiscount;
	

}
