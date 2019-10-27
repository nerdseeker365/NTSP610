package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private  EmployeeDAO dao;

	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
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
