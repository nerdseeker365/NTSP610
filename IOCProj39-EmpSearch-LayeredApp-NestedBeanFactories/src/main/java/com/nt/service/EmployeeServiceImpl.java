package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}


	public List<EmployeeDTO> findEmpsByDesg(String desg) throws Exception {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		
		//use DAO
		listBO=dao.searchEmpsByDesg(desg);
		//convert listBO to ListDTO
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO) {
			//copy each BO to each DTO class obj
			dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		}//for
		return listDTO;
	}//method
}//class
