package com.nt.service;

import com.nt.external.DubailCCScoreComp;
import com.nt.locator.DubailCCScoreCompServiceLocator;

public class CBuzzFindScoreServiceImpl implements CBuzzFindScoreService {
	private String jndi;
	
	public CBuzzFindScoreServiceImpl(String jndi) {
		this.jndi = jndi;
	}

	public  String  findScore(int mid) {
		String score=null;
		DubailCCScoreComp extComp=null;
		//get Extenal comp ref from ServiceLocator
		extComp=DubailCCScoreCompServiceLocator.getExtService(jndi);
		//use extCompref
		score=extComp.getScore(mid);
		return score;
	}
	
	
	

}
