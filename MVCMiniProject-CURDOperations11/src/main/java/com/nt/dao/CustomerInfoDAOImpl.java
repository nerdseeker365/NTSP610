package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.CustomerBO;

public class CustomerInfoDAOImpl implements CustomerInfoDAO {
	private static final String  GET_ALL_CUSTOMERS="SELECT CNO,CNAME,CADD,MOBILENO,BILLAMT FROM CUSTOMERINFO";
	private static final String  GET_CUSTOMER_BY_CNO="SELECT  CNO,CNAME,CADD,MOBILENO,BILLAMT FROM CUSTOMERINFO WHERE CNO=?";
	private static final  String  UPDATE_CUSTOMER_BY_CNO="UPDATE CUSTOMERINFO SET CNAME=?,CADD=?,MOBILENO=?,BILLAMT=? WHERE CNO=?";
	private static final  String  DELETE_CUSTOMER_BY_CNO="DELETE FROM CUSTOMERINFO  WHERE CNO=?";
	private JdbcTemplate jt;

	public CustomerInfoDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<CustomerBO> getAllCustomers() {
	  List<CustomerBO> listBO=null;
	  listBO=jt.query(GET_ALL_CUSTOMERS,
			                         rs->{
			                        	 List<CustomerBO> listBO1=null;
			                        	 CustomerBO bo=null;
			                        	 listBO1=new ArrayList();
			                        	 while(rs.next()) {
			                        		 bo=new CustomerBO();
			                        		 bo.setCno(rs.getInt(1));
			                        		 bo.setCname(rs.getString(2));
			                        		 bo.setCadd(rs.getString(3));
			                        		 bo.setMobileNo(rs.getLong(4));
			                        		 bo.setBillAmt(rs.getFloat(5));
			                        		 listBO1.add(bo);
			                        	 }//while
			                        	 return listBO1;
			                         });
	  return listBO;
	}//method

	@Override
	public CustomerBO getCustomerByCno(int cno) {
		CustomerBO bo=null;
		bo=jt.queryForObject(GET_CUSTOMER_BY_CNO,
				                                (rs,index)->{
				                                	CustomerBO bo1=new CustomerBO();
				                                	bo1.setCno(rs.getInt(1));
				                                	bo1.setCname(rs.getString(2));
				                                	bo1.setCadd(rs.getString(3));
				                                	bo1.setMobileNo(rs.getLong(4));
				                                	bo1.setBillAmt(rs.getFloat(5));
				                                	return bo1;
				                                },
				                                cno);
				                               
		
		return bo;
	}

	@Override
	public int updateCustomerByNo(CustomerBO bo) {
		int count=0;
		count=jt.update(UPDATE_CUSTOMER_BY_CNO,bo.getCname(),bo.getCadd(),bo.getMobileNo(),bo.getBillAmt(),bo.getCno());
		return count;
	}
	
	@Override
	public int deleteCustomerByNo(int cno) {
		int  count=0;
		count=jt.update(DELETE_CUSTOMER_BY_CNO,cno);
		return count;
	}

	

}//class
