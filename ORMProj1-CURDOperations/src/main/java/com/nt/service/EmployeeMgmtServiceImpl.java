package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeHLO;

@Service("empMgmtService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private  EmployeeDAO dao;

	public EmployeeDTO searchEmpByNo(int no) {
		EmployeeHLO hlo=null;
		EmployeeDTO dto=null;
		//use DAO
		hlo=dao.getEmpByNo(no);
		//convert hlo  to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(hlo, dto);
		return dto;
	}

	@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgmr",readOnly=false)
	public String registerEmp(EmployeeDTO dto) {
		EmployeeHLO hlo=null;
		int idVal=0;
		//convert  DTO into HLO
		hlo=new EmployeeHLO();
		BeanUtils.copyProperties(dto,hlo);
        //use dAO
		idVal=dao.insertEmp(hlo);
		return "Emp registred with "+idVal;
	}
	
	public float  findEmpSalary(int no) {
		float salary=0.0f;
		//use DAO
		salary=dao.getEmpSalaryByNo(no);
		return salary;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgmr",readOnly=false)
	public String hikeEmpSalary(int no, float percentage) {
		float salary=0.0f,newSalary=0.0f;
		int count=0;
		//useDAO
		salary=dao.getEmpSalaryByNo(no);
		newSalary=salary+(salary*(percentage)/100.0f);
		count=dao.updateEmpSalaryByNo(no, newSalary);
		if(count==1)
			return "Employee salary is hiked ::: new salary:::"+newSalary;
		else
			return "Employee salary is not hiked ";
	}
	
	public String fireEmpsBySalaryRange(float startSalary, float endSalary) {
		int count=0;
		//use dAO
		count=dao.deleteEmpsBySalaryRange(startSalary, endSalary);
		
		return count+" no.of emps are removed becoz of recision";
	}
	
	

}
