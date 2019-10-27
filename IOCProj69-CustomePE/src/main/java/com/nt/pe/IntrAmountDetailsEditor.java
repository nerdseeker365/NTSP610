package com.nt.pe;

import java.beans.PropertyEditorSupport;

import com.nt.beans.IntrestAmountDetails;

public class IntrAmountDetailsEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	    String tokens[]=null;
	    float pAmt=0.0f, time=0.0f,rate=0.0f;
	    IntrestAmountDetails details=null;
	    tokens=text.split(",");
	    pAmt=Float.parseFloat(tokens[0]);
	    time=Float.parseFloat(tokens[1]);
	    rate=Float.parseFloat(tokens[2]);
	    //convert values into IntrestAmountDetails class obj
	    details=new IntrestAmountDetails();
	    details.setPAmt(pAmt); details.setRate(rate); details.setTime(time);
	    //set value to Property
	    setValue(details);
	    
	    
	}

}
