package com.nt.external;

public class DubaiICCScoreCompImpl implements DubailCCScoreComp {

	@Override
	public String getScore(int mid) {
		if(mid==1001)
			return "IND Vs PAK --> Ind:300/9";
		else if(mid==1002)
			return "AUS Vs ENG --> AUS:200/2";
		else 
			return "Invalid Match Id ";
	}

}
