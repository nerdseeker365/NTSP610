package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private  EmployeeRepository empRepo;

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		Employee  emp=null;
		//convert  DTO to Model
		emp=new Employee();
		BeanUtils.copyProperties(dto,emp);
		//save object
		emp=empRepo.save(emp);
	     if(emp!=null)
		    return "Employee registred as Doument";
	     else
	    	 return "Employee not registered";
	}
	
	@Override
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeDTO> listDTO=new ArrayList();
		List<Employee> listDocs=null;
		listDocs=empRepo.findAll();
		//convert listDocs to listDTO
		listDocs.forEach(doc->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(doc,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public String updateEmployee(int eid, String newDesg, float newSalary) {
		Employee doc=null;
		//Load Document
		doc=empRepo.findById(eid).get();
		doc.setDesg(newDesg);
		doc.setSalary(newSalary);
		//update obj
		doc=empRepo.save(doc);
		if(doc!=null)
			return "Employee  updated";
		else
			return "Employee not updated";
	}
	
	

}
