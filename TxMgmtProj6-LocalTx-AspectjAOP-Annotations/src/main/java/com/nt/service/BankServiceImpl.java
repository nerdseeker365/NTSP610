package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
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

	@Transactional(propagation=Propagation.REQUIRED,timeout=10,rollbackFor=IllegalAccessException.class)
	public boolean transferMoney(int srcAcno, int destAcno, float amount)throws IllegalAccessException{
		boolean withdrawFlag=false,depositeFlag=false;
		boolean statusFlag=false;
	
		try {
			Thread.sleep(12000);
		}
		catch(InterruptedException ire) {
			ire.printStackTrace();
		} 
		 
		withdrawFlag=withdrawMoney(srcAcno, amount);
		depositeFlag=depositeMoney(destAcno, amount);
		
	
		 
		if(withdrawFlag==true && depositeFlag==true) {
			statusFlag=true;
		}
		else {
			statusFlag=false;
			throw new IllegalAccessException();
		}
		return statusFlag;
	}//method

	@Transactional(readOnly=true)
	public float showBalance(int acno) {
		float salary=0.0f;
		//use DAO
				salary=dao.getBalnace(acno);
		return salary;
	}
	
	
	
}//class
