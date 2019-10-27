package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String  GET_SNO_SEQ="SELECT SNO_SEQ.NEXTVAL FROM DUAL";
	private SimpleJdbcInsert sji;
	private JdbcTemplate jt;

	public StudentDAOImpl(SimpleJdbcInsert sji,JdbcTemplate jt) {
		this.sji = sji;
		this.jt=jt;
	}
	
	private    int  getSeqSno() {
		int sno=0;
		sno=jt.queryForObject(GET_SNO_SEQ, Integer.class);
		return sno;
	}
	
	



	@Override
	public int insert(StudentBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count = 0;
		//set sno Bo class object
		bo.setSno(getSeqSno());
		// set Table name
		sji.setTableName("STUDENT");
	  //set Bean property values
		bpsps=new BeanPropertySqlParameterSource(bo);
		// execute the Query
		count = sji.execute(bpsps);
		return count;
	}

}
