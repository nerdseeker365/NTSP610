package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private WithdrawDAO wDao;
	@Autowired
	private  DepositeDAO dDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean transferMoney(int srcAcno, int destAcno, float amt) {
		boolean flag=false;
		int count1=0,count2=0;
		count1=wDao.withdraw(srcAcno, amt);
		count2=dDao.deposite(destAcno, amt);
		if(count1==0 || count2==0) {
			flag=false;
			throw new RuntimeException();
		}
		else {
			flag=true;
		}
		return flag;
	}

}
