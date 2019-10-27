package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO CUSTOMERINFO VALUES(CNO_SEQ.NEXTVAL,?,?,?,?)";
	private JdbcTemplate jt;

	public CustomerDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(CustomerBO bo) {
		  int count=0;
		  count=jt.update(INSERT_CUSTOMER_QUERY,bo.getCname(),bo.getCadd(),bo.getMobileNo(),bo.getBillAmt());
		return count;
	}

}
