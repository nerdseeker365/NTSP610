package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	private JdbcTemplate jt;
	

	@Override
	public List<Map<String, Object>> searchDeptsByLoc(String cond) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList("SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE LOC IN "+cond,new Object[] {} );
		return list;
	}

}
