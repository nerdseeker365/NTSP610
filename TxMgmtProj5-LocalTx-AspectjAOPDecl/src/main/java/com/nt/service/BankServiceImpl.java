package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	public boolean withdrawMoney(int acno, float amount) {
		int count=0;
		//use DAO
		count=dao.widraw(acno, amount);
		if(count==0)
			return false;
		else
			return true;
	}

	public boolean depositeMoney(int acno, float amount) {
		int count=0;
		//use DAO
		count=dao.deposite(acno, amount);
		if(count==0)
			return false;
		else
			return true;
	}

	public boolean transferMoney(int srcAcno, int destAcno, float amount){
		boolean withdrawFlag=false,depositeFlag=false;
		boolean statusFlag=false;
		/* try { Thread.sleep(15000); } 
		 catch(InterruptedException ire) {
		ire.printStackTrace(); } */
		 
		withdrawFlag=withdrawMoney(srcAcno, amount);
		depositeFlag=depositeMoney(destAcno, amount);
		
	
		 
		if(withdrawFlag==true && depositeFlag==true) {
			statusFlag=true;
		}
		else {
			statusFlag=false;
			throw new RuntimeException();
		}
		return statusFlag;
	}//method

	public float showBalance(int acno) {
		float salary=0.0f;
		//use DAO
				salary=dao.getBalnace(acno);
		return salary;
	}
	
	
	
}//class
