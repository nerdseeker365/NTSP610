package com.nt.service;

public interface BankService {
	public boolean  withdrawMoney(int acno,float amount);
	public boolean  depositeMoney(int acno,float amount);
	public boolean transferMoney(int srcAcno,int destAcno,float amount);
	public   float  showBalance(int acno);

}
