package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	@NonNull
	private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		int count = 0;
		// use DAO
		count = dao.getEmpsCount();
		return count;
	}

	@Override
	public String fetchEmpNameById(int eno) {
		String name = null;
		// use DAO
		name = dao.getEmpNameById(eno);
		return name;
	}

	@Override
	public Map<String, Object> fetchEmpDetailsById(int id) {
		Map<String, Object> map = null;
		// use DAO
		map = dao.getEmpById(id);
		return map;
	}

	@Override
	public List<Map<String, Object>> fetchEmpDetailsDesg(String desg) {
		List<Map<String, Object>> list = null;
		// use DAO
		list = dao.getEmpsByDesg(desg);
		return list;
	}

	@Override
	public String registerEmployee(int id, String name, String desg, int salary) {
		int count = 0;
		// use DAO
		count = dao.insert(id, name, desg, salary);
		if (count == 0)
			return "registration failed";
		else
			return "registration succeded";
	}
	
	@Override
	public String fireEmployee(int eid) {
		int count=0;
		//use DAO
		count=dao.delete(eid);
		if(count==0)
			return "Employee not found to delete";
		else
			return "Employee  found and deleted";
	}
	
	@Override
	public String addPongalBonus(int bonus, int startSalary, int endSalary) {
		int count=0;
		//use DAO
		count=dao.updateSalary(bonus, startSalary, endSalary);
		if(count==0)
			return "no matching records found";
		else
			return count+" no.of Employees are benifited with bonus";
	}
	
}//class
