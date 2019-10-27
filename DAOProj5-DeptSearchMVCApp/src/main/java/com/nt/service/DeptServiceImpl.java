package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.DeptDAO;

public class DeptServiceImpl implements DeptService {
	
	private  DeptDAO dao;
	

	public DeptServiceImpl(DeptDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<Map<String, Object>> findDeptsByLocations(String[] locations) {
		List<Map<String,Object>> list=null;
		StringBuffer sb=null;
		//prepare SQL Condition like this ('BOSTON','CHICAGO','DALLAS')
		sb=new StringBuffer("(");
		for(int i=0;i<locations.length;++i) {
			if(i==locations.length-1)
				 sb.append("'"+locations[i]+"'");
			else
				sb.append("'"+locations[i]+"',");
		}//for
		sb.append(")");
		//use DAO
		list=dao.searchDeptsByLoc(sb.toString());
		return list;
	}

}
