package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=:id";
	private static final String  GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3)";
	private static final  String  INSERT_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:eno,:ename,:desg,:salary)";
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	public EmployeeBO getEmpById(int id) {
		Map<String,Object> paramMap=null;
		EmployeeBO bo=null;
		//prepare Map object having Named Param value
		paramMap=new HashMap();
		paramMap.put("id",id);
		// execute the query
		bo=npjt.queryForObject(GET_EMP_BY_ID,
				                                       paramMap,
				                                       (rs,index)->{
			EmployeeBO ebo=new EmployeeBO();
			ebo.setEno(rs.getInt(1));
			ebo.setEname(rs.getString(2));
			ebo.setDesg(rs.getString(3));
			ebo.setSalary(rs.getInt(4));
			return ebo;
		});
		return bo;
	}//method
	
	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		MapSqlParameterSource msps=null;
		//Prepare MapSqlParameterSource class object
		msps=new MapSqlParameterSource();
		msps.addValue("desg1",desg1);
		msps.addValue("desg2",desg2);
		msps.addValue("desg3",desg3);
		//execute Query
		listBO=npjt.query(GET_EMPS_BY_DESGS,
				                          msps,
				                          rs->{
				                        	  List<EmployeeBO> listEBO=null;
				                        	  EmployeeBO bo=null;
				                        	  listEBO=new ArrayList();
				                        	  while(rs.next()) {
				                        		  bo=new EmployeeBO();
				                        		  bo.setEno(rs.getInt(1));
				                        		  bo.setEname(rs.getString(2));
				                        		  bo.setDesg(rs.getString(3));
				                        		  bo.setSalary(rs.getInt(4));
				                        		  listEBO.add(bo);
				                        	  }
				                        	 return listEBO;
				                          });
		return listBO;
	}//method
	
	@Override
	public int insert(EmployeeBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=null;
		//prepepare BeanPropertySqlParameterSource class obj having Param values
		bpsps=new  BeanPropertySqlParameterSource(bo);
		count=npjt.update(INSERT_QUERY, bpsps);
		return count;
	}
	
	

}//class
