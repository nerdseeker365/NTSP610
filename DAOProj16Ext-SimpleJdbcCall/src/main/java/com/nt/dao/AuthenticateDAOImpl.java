package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("authDAO")
public class AuthenticateDAOImpl implements AuthenticationDAO {
	@Autowired
	private  SimpleJdbcCall sjc;

	@Override
	public Map<String, Object> authenticate(UserBO bo) {
	    Map<String,Object> inParams=null;
	    Map<String,Object> outParams=null;
	    inParams=new HashMap();
	    inParams.put("user",bo.getUsername());
	    inParams.put("pass",bo.getPassword());
	    //setProcedure name
	    sjc.setProcedureName("P_AUTHENTICATE");
	    //execute PL/SQL Procedure
	    outParams=sjc.execute(inParams);
		return outParams;
	}

}
