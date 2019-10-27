package com.nt.bo;

import java.io.Serializable;


public class PassengerBO implements Serializable {
	private String  psngrName;
	private String  gender;
	private String boardingPlace;
	private String destPlace;
	public String getPsngrName() {
		return psngrName;
	}
	public void setPsngrName(String psngrName) {
		this.psngrName = psngrName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBoardingPlace() {
		return boardingPlace;
	}
	public void setBoardingPlace(String boardingPlace) {
		this.boardingPlace = boardingPlace;
	}
	public String getDestPlace() {
		return destPlace;
	}
	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}
	

}
