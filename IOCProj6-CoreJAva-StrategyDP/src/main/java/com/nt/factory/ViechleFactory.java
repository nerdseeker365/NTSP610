package com.nt.factory;

import com.nt.beans.CNGEngine;
import com.nt.beans.DieselEngine;
import com.nt.beans.Engine;
import com.nt.beans.PetrolEngine;
import com.nt.beans.Viechle;

public class ViechleFactory {
	
	public static  Viechle getInstance(String engineType) {
		  Viechle viechle=null;
		  Engine engine=null;
		  //create Engine object
		  if(engineType.equalsIgnoreCase("petrol")) {
			  engine=new PetrolEngine();
		  }
		  else if(engineType.equalsIgnoreCase("diesel")) {
			  engine=new DieselEngine();
		  }
		  else if(engineType.equalsIgnoreCase("CNG")) {
			  engine=new CNGEngine();
		  }
		  else {
			  throw new IllegalArgumentException("Invalid Engine Type");
		  }
		  //create Viechle object having Engine object
		  viechle=new Viechle();
		  viechle.setEngine(engine);
		  return viechle;
	}

}
