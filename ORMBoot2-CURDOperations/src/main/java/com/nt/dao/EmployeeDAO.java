package com.nt.dao;

import com.nt.entity.EmployeeHLO;

public interface EmployeeDAO {
	public    EmployeeHLO   getEmpByNo(int no);
	public    int    insertEmp(EmployeeHLO hlo);
	public  float   getEmpSalaryByNo(int no);
	public   int   updateEmpSalaryByNo(int no,float newSalary);
	public  int  deleteEmpsBySalaryRange(float startSalary,float endSalary);

}
