package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDAOImpl implements DeptDAO {
	private JdbcTemplate jt;
	
	public  DeptDAOImpl(JdbcTemplate jt) {
		this.jt=jt;
	}

	@Override
	public List<Map<String, Object>> searchDeptsByLoc(String cond) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList("SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE LOC IN "+cond,new Object[] {} );
		return list;
	}

}
