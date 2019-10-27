package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
   @Autowired
	private  EmployeeRepository  empRepo;

@Override
public void fetchAllEmployees(int pageSize) {
	Pageable pagable=null;
	Page<Employee> listEnties=null;
	long total=0,pagesCount=0;
	
	 total=empRepo.count();
	 pagesCount=total/pageSize;
	if(total%pageSize!=0)
		pagesCount++;
	
	for(int pageNo=0;pageNo<pagesCount;pageNo++) {
		pagable=PageRequest.of(pageNo,pageSize,Sort.by("desg").descending());
		listEnties=empRepo.findAll(pagable);
		listEnties.forEach(emp->{
			System.out.println(emp);
		});
		System.out.println(".............................."+(pageNo+1)+" of"+pagesCount);
	}
	
	
	

}//method

}//class
