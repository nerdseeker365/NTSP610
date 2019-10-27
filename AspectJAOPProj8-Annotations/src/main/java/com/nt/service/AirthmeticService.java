package com.nt.service;

import org.springframework.stereotype.Service;

@Service("arthService")
public class AirthmeticService {
	public float sum(float x,float y) {
		return x+y;
	}
	public float sub(float x,float y) {
		return x-y;
	}
	
	public float mul(float x,float y) {
		return x*y;
	}
	
	public float div(float x,float y) {
		return x/y;
	}




}
