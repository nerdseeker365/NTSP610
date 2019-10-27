package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String  GET_SNO_SEQ="SELECT SNO_SEQ.NEXTVAL FROM DUAL";
	@Autowired
	private SimpleJdbcInsert sji;
	@Autowired
	private JdbcTemplate jt;

	
	
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
