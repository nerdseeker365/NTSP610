package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	
	public  int  getEmpsCount();
	public  String  getEmpNameById(int no);
	public  Map<String,Object>  getEmpById(int id);
	public List<Map<String,Object>> getEmpsByDesg(String desg);
	public  int insert(int eno,String ename,String desg,int salary);
	public  int delete(int eno);
	public  int updateSalary(int bonus,int startSalary,int endSalary);
	
	

}
