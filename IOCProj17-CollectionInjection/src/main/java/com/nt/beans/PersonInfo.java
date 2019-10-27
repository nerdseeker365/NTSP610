package com.nt.beans;

import java.util.Date;
import java.util.Set;



public class PersonInfo {
	private Set<Long>  phoneNumbers;
	private Set<Date> dates;

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		System.out.println(phoneNumbers.getClass());
		this.phoneNumbers = phoneNumbers;
	}

	public void setDates(Set<Date> dates) {
		this.dates = dates;
	}
	
	@Override
	public String toString() {
		return "PersonInfo [phoneNumbers=" + phoneNumbers + ", dates=" + dates + "]";
	}
	
	

}
