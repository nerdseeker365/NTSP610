package com.nt.beans;

import java.util.Random;

public class Bat {
	private String make;

	public void setMake(String make) {
		this.make = make;
	}
	
	public int scoreRuns() {
		return  new Random().nextInt(200);
	}

}
