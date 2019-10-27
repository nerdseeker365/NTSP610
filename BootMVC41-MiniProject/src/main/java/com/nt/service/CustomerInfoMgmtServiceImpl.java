package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerInfoDAO;
import com.nt.dto.CustomerDTO;

@Named("custService")
public class CustomerInfoMgmtServiceImpl implements CustomerInfoMgmtService {
	@Resource
	private  CustomerInfoDAO dao;
	
	
    
    
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="dsTxMgmr")
	public List<CustomerDTO> fetchAllCustomers() {
		List<CustomerBO> listBO=null;
		List<CustomerDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllCustomers();
		//copy listBO to listDTO
		listBO.forEach(bo->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}//method



	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="dsTxMgmr")
	public CustomerDTO fetchCustomerByCno(int cno) {
		CustomerBO bo=null;
		CustomerDTO dto=null;
		//use DAO
		bo=dao.getCustomerByCno(cno);
		//copy BO  to DTO
		dto=new CustomerDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="dsTxMgmr")
	public String modifyCustomerByNo(CustomerDTO dto) {
		CustomerBO bo=null;
		int count=0;
		//convert DTO to BO
		bo=new CustomerBO();
	   BeanUtils.copyProperties(dto,bo);
	   //use DAO
	   count=dao.updateCustomerByNo(bo);
		if(count==0)
			return "Record not found for updation";
		else
			return "Record  found and updated";
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="dsTxMgmr")
	public String removeCustomerByNo(int cno) {
		int count=0;
		//use DAO
		count=dao.deleteCustomerByNo(cno);
		if(count==0)
			return "Customer not found for Deletion";
		else
			return "Customer  found and Deleted";
	}

}//class
