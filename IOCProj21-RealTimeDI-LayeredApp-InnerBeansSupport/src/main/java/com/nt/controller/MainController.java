package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public final class MainController {
	private StudentService service;
	
	public MainController() {
		System.out.println("MainController.MainController()");
	}

	public void setService(StudentService service) {
		System.out.println("MainController.setService(-)");
		this.service = service;
	}
	
	public  String generateResult(StudentVO vo)throws Exception{
		System.out.println("MainController.generateResult(-)");
		 StudentDTO dto=null;
		 String result=null;
		//Convert StudentVO class obj to StudentDTO class obj
		 dto=new StudentDTO();
		 dto.setSno(Integer.parseInt(vo.getSno()));
		 dto.setSname(vo.getSname());
		 dto.setM1(Integer.parseInt(vo.getM1()));
		 dto.setM2(Integer.parseInt(vo.getM2()));
		 dto.setM3(Integer.parseInt(vo.getM3()));
		 //use Service
		 result=service.evaluateResult(dto);
		 return result;
	}
	

}
