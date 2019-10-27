package com.nt.service;

import com.nt.external.DubailCCScoreComp;

public class CBuzzFindScoreServiceImpl implements CBuzzFindScoreService {
	private DubailCCScoreComp extComp;

	public CBuzzFindScoreServiceImpl(DubailCCScoreComp extComp) {
		this.extComp = extComp;
	}
	
	public  String  findScore(int mid) {
		String score=null;
		//use extCompref
		score=extComp.getScore(mid);
		return score;
	}
	
	
	

}
