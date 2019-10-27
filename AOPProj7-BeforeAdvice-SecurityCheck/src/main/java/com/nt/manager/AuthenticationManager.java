package com.nt.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserInfoBO;
import com.nt.dao.AuthenticationDAO;
import com.nt.dto.UserInfoDTO;

@Service("authManager")
public class AuthenticationManager {
	@Autowired
	private AuthenticationDAO dao;
	private  ThreadLocal<UserInfoDTO> threadLocal=new ThreadLocal();
	
	public void signIn(String username,String pwd) {
		UserInfoDTO dto=null;
		//put credentials in DTO class object
		dto=new UserInfoDTO();
		dto.setUname(username);
		dto.setPwd(pwd);
		//add to ThreadLocal
		threadLocal.set(dto);
	}
	
	public void signOut() {
		threadLocal.remove();
	}
	
	public boolean validate() {
		UserInfoDTO dto=null;
		UserInfoBO bo=null;
		int count=0;
		dto=threadLocal.get();
		//convert DTO class object BO class object
		bo=new UserInfoBO();
		BeanUtils.copyProperties(dto, bo);
		//use dAO
		count=dao.authenticate(bo);
		//process the reuslt
		if(count==0)
			return false;
		else


	}
	
	
	
	
	

}
