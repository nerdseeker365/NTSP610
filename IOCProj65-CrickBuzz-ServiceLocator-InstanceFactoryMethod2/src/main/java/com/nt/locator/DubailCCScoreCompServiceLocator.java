package com.nt.locator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.nt.external.DubaiICCScoreCompImpl;
import com.nt.external.DubailCCScoreComp;

public class DubailCCScoreCompServiceLocator {
    private  Map<String,DubailCCScoreComp> cache=new HashMap();
	
    
	
	public  DubailCCScoreComp getExtService(String jndi) {
		
		/* Actually we  need to write jndi lookup here, but we writing direct
		 *  logic to create Extenal Service class obj becoz it is developed
		 *  as ordinary java class
		 */
		if(!cache.containsKey(jndi)) {
			cache.put(jndi,new DubaiICCScoreCompImpl());
		}
		return  cache.get(jndi);
	}//method


}
