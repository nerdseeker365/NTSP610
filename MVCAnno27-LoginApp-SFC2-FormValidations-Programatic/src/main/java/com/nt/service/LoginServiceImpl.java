package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String validate(UserDTO dto) {
		int count=0;
		UserBO bo=null;
		//convert DTO to BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
	   //use DAO
		count=dao.authenticate(bo);
		if(count==0)
			return "InValid Credentials";
		else
			return "Valid Credentials";
	}

}
