package com.nt.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.AuthenticationDAO;
import com.nt.dto.UserDTO;

@Service("authService")
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
	private AuthenticationDAO dao;
	@Override
	public String login(UserDTO dto) {
		UserBO bo=null;
		Map<String,Object> outParams=null;
		//convert DTO to  BO
		bo=new UserBO();
	   BeanUtils.copyProperties(dto,bo);
		//use DAO
	   outParams=dao.authenticate(bo);
	   return (String)outParams.get("RESULT");
	}

}
