package com.nt.service;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public   EmployeeDTO   searchEmpByNo(int no);
	public   String   registerEmp(EmployeeDTO dto);
	public   float  findEmpSalary(int no);
	public   String   hikeEmpSalary(int no,float percentage);
	public   String   fireEmpsBySalaryRange(float startSalary,float endSalary);

}
