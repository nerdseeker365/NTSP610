package com.nt.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.nt.dao.BankDAO;

@Named("bankService")
public class BankServiceImpl implements BankService {
	@Inject
	private BankDAO dao;

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
		withdrawFlag=withdrawMoney(srcAcno, amount);
		depositeFlag=depositeMoney(destAcno, amount);
		/*
		 * try { Thread.sleep(15000); } 
		 * catch(InterruptedException ire) {
		 * ire.printStackTrace(); }
		 */
		if(withdrawFlag==true && depositeFlag==true) {
			statusFlag=true;
		}
		else {
			statusFlag=false;
			throw new RuntimeException();
		}
		return statusFlag;
	}//method
}//class
