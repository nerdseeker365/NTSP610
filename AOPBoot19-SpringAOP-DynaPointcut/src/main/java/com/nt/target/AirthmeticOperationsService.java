package com.nt.target;

import org.springframework.stereotype.Service;

@Service("airthService")
public class AirthmeticOperationsService {
	
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
