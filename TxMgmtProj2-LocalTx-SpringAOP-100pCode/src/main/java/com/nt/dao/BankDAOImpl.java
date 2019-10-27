package com.nt.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;

@Named("bankDAO")
public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";

	@Inject
	private JdbcTemplate jt;

	

	public int widraw(int acno, float amt) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY, amt,acno);
		return count;
	}

	public int deposite(int acno, float amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY,amt,acno);
		return count;
	}

}
