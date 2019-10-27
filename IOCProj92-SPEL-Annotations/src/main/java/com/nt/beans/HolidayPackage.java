package com.nt.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("hp")
@PropertySource("classpath:com/nt/commons/info.properties")
public class HolidayPackage {
	@Value("#{T(java.lang.Math).random()*100}")
	private int packageId;
	@Value("#{'${packageName}'}")
	private String packageName;
	@Value("#{dt}")
	private  Date   date;
	@Value("#{'${placesAvailable}'.split(',')}")
	private  List<String> placesAvailable;
	@Value("#{${placesPrices}}")
	private  Map<String,Integer> placesPrices; 
	@Value("#{'${treatmentTypes}'.split(',')}")
	private  String[]  treatmentTypes;
	@Value("#{'${durations}'.split(',')}")
	private  int[] durations;
	@Value("#{'${offerDiscount}'}")
	private  float offerDiscount;
	

}
