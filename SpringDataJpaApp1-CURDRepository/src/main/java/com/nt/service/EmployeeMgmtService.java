package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public   List<EmployeeDTO>  getAllEmployees();
	public  EmployeeDTO   getEmployeeById(int id);
	public  List<EmployeeDTO>  getEmployeesByDesgs(String desg1,String desg2);
    public  long   getEmployeesCount();
    public   long   getEmployeesSalariesCount();
    public   String  registerEmployee(EmployeeDTO dto);
    public  String  addBonusToEmployeesByDesg(String desg,float bonus);
}
