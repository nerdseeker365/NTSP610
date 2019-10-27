package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

@Component("controller")
public final class MainController {
	@Autowired
	private StudentService service;
	
	
	
	public  String generateResult(StudentVO vo)throws Exception{
		System.out.println("MainController.generateResult(-)");
		 StudentDTO dto=null;
		 String result=null;
		//Convert StudentVO class obj to StudentDTO class obj
		 dto=new StudentDTO();
		 dto.setSname(vo.getSname());
		 dto.setM1(Integer.parseInt(vo.getM1()));
		 dto.setM2(Integer.parseInt(vo.getM2()));
		 dto.setM3(Integer.parseInt(vo.getM3()));
		 //use Service
		 result=service.evaluateResult(dto);
		 return result;
	}
	

}
