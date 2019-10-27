package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;
import com.nt.entity.UserHLO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDAO dao;

	@Override
	//@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgmr",readOnly=true)
	public String validate(UserDTO dto) {
		long count=0;
		UserHLO bo=null;
		//convert DTO to BO
		bo=new UserHLO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
	     count=dao.authenticate(bo);
		return  count!=0?"Valid Crendentianls": "Invalid Credentials";
	}

}
