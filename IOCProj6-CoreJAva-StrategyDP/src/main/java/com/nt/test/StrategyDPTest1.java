package com.nt.test;

import com.nt.beans.Viechle;
import com.nt.factory.ViechleFactory;

public class StrategyDPTest1{

	public static void main(String[] args) {
		Viechle viechle=null;
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("CNG");
		viechle.journey("hyd", "chennai");
		System.out.println("....................................");
		//Get Target class obj having Dependent class obj
				viechle=ViechleFactory.getInstance("Petrol");
				viechle.journey("hyd", "delhi");
	}

}
