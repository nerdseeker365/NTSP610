package com.nt.service;


import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.RegistrationDAO;

public  abstract class RegistrationServiceImpl implements RegistrationService {
	private RegistrationDAO dao;
	
	public RegistrationServiceImpl() {
		System.out.println("RegistrationServiceImpl::0-param constructor");
	}
	
	public void setDao(RegistrationDAO dao) {
		this.dao = dao;
	}
	
	public  abstract  StudentBO  createStudentBO();
	public  abstract  EmployeeBO  createEmployeeBO();

	@Override
	public void registerStudent(String name, String addrs, String course) {
		StudentBO bo=null;
		//get StudentBO class obj
		bo=createStudentBO();
		bo.setName(name); bo.setCourse(course); bo.setAddrs(addrs);
		//use DAO
		dao.insertStudent(bo);
	}
	
	@Override
	public void registerEmployee(String name, String addrs, String desg) {
		EmployeeBO bo=null;
	  //get EmployeeBO class obj
		bo=createEmployeeBO();
		bo.setName(name); bo.setAddrs(addrs);bo.setDesg(desg);
		dao.insertEmployee(bo);
	}

}
