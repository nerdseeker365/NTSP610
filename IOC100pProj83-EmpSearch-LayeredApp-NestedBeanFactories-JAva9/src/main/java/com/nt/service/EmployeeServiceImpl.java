package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Named("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Inject
	private EmployeeDAO dao;
	
	public List<EmployeeDTO> findEmpsByDesg(String desg) throws Exception {
		List<EmployeeBO> listBO=null;
		final List<EmployeeDTO> listDTO=new ArrayList();
	  
		//use DAO
		listBO=dao.searchEmpsByDesg(desg);
		//convert listBO to ListDTO
		
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method
}//class
