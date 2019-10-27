package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private SimpleJdbcInsert sji;

	public StudentDAOImpl(SimpleJdbcInsert sji) {
		this.sji = sji;
	}

	/*
	 * @Override public int insert(StudentBO bo) { Map<String,Object> map=null; int
	 * count=0; //set Table name sji.setTableName("STUDENT"); //prepare Map object
	 * map=new HashMap(); map.put("sno",bo.getSno());
	 * map.put("sname",bo.getSname()); map.put("sadd",bo.getSadd()); //execute the
	 * Query count=sji.execute(map);
	 * 
	 * return count; }
	 */

	@Override
	public int insert(StudentBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count = 0;
		// set Table name
		sji.setTableName("STUDENT");
	  //set Bean property values
		bpsps=new BeanPropertySqlParameterSource(bo);
		// execute the Query
		count = sji.execute(bpsps);
		return count;
	}

}
