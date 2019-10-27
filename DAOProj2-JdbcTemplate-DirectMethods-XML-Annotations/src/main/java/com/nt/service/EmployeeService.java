package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	public  int  fetchEmpsCount();
	public  String fetchEmpNameById(int eno);
	public  Map<String,Object> fetchEmpDetailsById(int id);
	public  List<Map<String,Object>> fetchEmpDetailsDesg(String desg);
	public String  registerEmployee(int id,String name,String desg,int salary);
	public  String  fireEmployee(int eid);
	public String   addPongalBonus(int bonus,int startSalary,int endSalary);

}
