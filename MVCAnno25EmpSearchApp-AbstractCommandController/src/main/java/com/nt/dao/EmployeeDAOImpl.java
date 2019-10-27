package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPS_BY_INPUTS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP  WHERE (EMPNO IS NOT NULL AND EMPNO=?) OR (ENAME IS NOT NULL AND ENAME LIKE ?) OR (JOB IS NOT  NULL AND JOB LIKE ?) OR (SAL IS NOT NULL AND SAL=?) ORDER BY JOB";
    @Autowired
	private JdbcTemplate jt;


	@Override
	public List<EmployeeResultBO> findByInputs(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO=null;
		listRBO=jt.query(GET_EMPS_BY_INPUTS,
				                         new ResultSetExtractor<List<EmployeeResultBO>>() {

											@Override
											public List<EmployeeResultBO> extractData(ResultSet rs)
													throws SQLException, DataAccessException {
												EmployeeResultBO bo=null;
												List<EmployeeResultBO> listRBO1=new ArrayList();
												while(rs.next()) {
													bo=new EmployeeResultBO();
													bo.setEmpNo(rs.getInt(1));
													bo.setEname(rs.getString(2));
													bo.setJob(rs.getString(3));
													bo.setSal(rs.getFloat(4));
													bo.setDeptNo(rs.getInt(5));
													bo.setMgr(rs.getInt(6));
													listRBO1.add(bo);
												}//while
											
												return listRBO1;
											}//extractData()
			                              }//anonymous inner cklas
		                                 ,
				                         bo.getEmpNo(),bo.getEname(),bo.getJob(),bo.getSal());
		
		return listRBO;
	}//DAO methiod

}//dAO class
