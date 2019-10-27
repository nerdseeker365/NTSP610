package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private  EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeResultDTO> searchByInputs(EmployeeDTO dto) {
		List<EmployeeResultBO> listRBO=null;
		EmployeeBO bo=null;
		List<EmployeeResultDTO> listRDTO=new ArrayList();  
		//convert dto  to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		listRBO=dao.findByInputs(bo);
		//convert listRBO to listRDTO
		listRBO.forEach(bo1->{
			EmployeeResultDTO dto1=new EmployeeResultDTO();
			BeanUtils.copyProperties(bo1, dto1);
			dto1.setSrNo(listRDTO.size()+1);
			listRDTO.add(dto1);
		});
		return listRDTO;
	}//method
}//class
