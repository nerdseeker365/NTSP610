package com.nt.beans;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("tourist")
@PropertySource("classpath:com/nt/commons/info.properties")
public class Tourist {
	@Value("#{T(java.lang.Math).random()*100}")
	private int touristId;
	@Value("#{'${name}'}")
	private  String name;
	@Value("#{hp.packageName}")
	private String packageName;
	@Value("#{'${membersName}'.split(',')}")
	private  String[] membersName;
	@Value("#{T(java.util.Arrays).asList(hp.placesAvailable[0],hp.placesAvailable[2],hp.placesAvailable[3])}")
	private   Set<String> optedPlaces;
	@Value("#{hp.placesPrices['KBCBeaches']+hp.placesPrices['WaterSports']+hp.placesPrices['NiteLife']}")
	private   float price;
	@Value("#{(hp.placesPrices['KBCBeaches']+hp.placesPrices['WaterSports']+hp.placesPrices['NiteLife'])- (hp.placesPrices['KBCBeaches']+hp.placesPrices['WaterSports']+hp.placesPrices['NiteLife'])*(hp.offerDiscount/100)}")
	private   float finalPrice;
	@Value("#{hp.offerDiscount>0}")
	private   boolean offerAvaiable;
	@Value("#{hp.treatmentTypes[1]}")
	private  String tourMode;
	

}
