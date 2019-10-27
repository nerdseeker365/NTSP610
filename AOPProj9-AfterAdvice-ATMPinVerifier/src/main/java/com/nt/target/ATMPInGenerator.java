package com.nt.target;

import java.util.Random;

public class ATMPInGenerator {
	
	public   int  generatePin() {
		Random rad=null;
		int pin=0;
		rad=new Random();
		pin=rad.nextInt(9999);
		return pin;
	}

}
