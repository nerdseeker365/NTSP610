package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDTO;

public interface CustomerInfoMgmtService {
	public  List<CustomerDTO> fetchAllCustomers(); 
	public CustomerDTO fetchCustomerByCno(int cno);
	public  String modifyCustomerByNo(CustomerDTO dto);
	public  String  removeCustomerByNo(int cno);

}
