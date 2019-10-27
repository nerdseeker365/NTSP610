package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;

public interface EmployeeMgmtService {
	public  String registerEmployee(EmployeeDTO dto);
	public   List<EmployeeDTO> fetchAllEmployees();
	public   String     updateEmployee(int eid,String newDesg,float newSalary);

}
