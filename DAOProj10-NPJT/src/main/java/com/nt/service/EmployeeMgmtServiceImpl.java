package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
   @Autowired
	private  EmployeeDAO dao;
   
	@Override
	public EmployeeDTO searchEmpById(int id) {
		EmployeeBO bo=null;
		EmployeeDTO  dto=null;
	  //use dAO
		bo=dao.getEmpById(id);
		//convert BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
		public List<EmployeeDTO> searchEmpsByDesgs(String desg1, String desg2, String desg3) {
			List<EmployeeBO> listBO=null;
			List<EmployeeDTO>  listDTO=new ArrayList();
			//use dAO
			listBO=dao.getEmpsByDesg(desg1, desg2, desg3);
			//convert listBO to listDTO
			listBO.forEach(bo->{
				EmployeeDTO dto=new EmployeeDTO();
				BeanUtils.copyProperties(bo, dto);
				listDTO.add(dto);
			});
			
			return listDTO;
		}
	
	@Override
		public String register(EmployeeDTO dto) {
		   int count=0;
		   EmployeeBO bo=null;
		   //convert DTO into BO
		   bo=new EmployeeBO();
		   BeanUtils.copyProperties(dto,bo);
		   //use DAO
		  count=dao.insert(bo);
		  if(count==0)
		     return "Registration failed";
		  else
			  return  "registration succeded";
		}

}
