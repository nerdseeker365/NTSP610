package com.nt.target;

public class AirthmeticOperationsServiceImpl implements AirthmeticServiceOperations {
	
	public float add(float x,float y) {
		return x+y;
	}
	public float sub(float x,float y) {
		return x-y;
	}
	public float mul(float x,float y) {
		return x*y;
	}
	public  float div(float x,float y) {
		return (float)x/y;
	}

}
