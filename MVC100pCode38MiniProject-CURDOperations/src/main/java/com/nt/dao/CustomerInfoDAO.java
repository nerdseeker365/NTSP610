package com.nt.dao;

import java.util.List;

import com.nt.bo.CustomerBO;

public interface CustomerInfoDAO {
	public  List<CustomerBO>  getAllCustomers();
	public  CustomerBO  getCustomerByCno(int cno);
	public   int   updateCustomerByNo(CustomerBO bo);
	public   int  deleteCustomerByNo(int cno);
}
