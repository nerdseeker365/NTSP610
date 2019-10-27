package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;
	
	

	@Override
	public String withdrawMoney(int accno, float amount) {
		int count=0;
		//use DAO
		count=dao.withdraw(accno, amount);
		//process the Reuslt
		if(count==0)
			 return "Account number Not  found";
		else
			return  amount+" money withdrawn from Account number::"+accno;
	}

}
