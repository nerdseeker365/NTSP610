package com.nt.test;

import com.nt.beans.Viechle;
import com.nt.factory.ViechleFactory;

public class StrategyDPTest2{

	public static void main(String[] args) {
		Viechle viechle=null;
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("diesel");
		viechle.journey("hyd", "Goa");
	}

}
