package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	@NonNull
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	@NonNull
	private static final String GET_EMP_NAME_BY_ID="SELECT ENAME FROM EMP WHERE EMPNO=?";
	@NonNull
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	@NonNull
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	@NonNull
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	@NonNull
	private static final String DELETE_EMPLOYEE="DELETE FROM EMP WHERE EMPNO=?";
	@NonNull
	private static final String UPDATE_EMP_SAL_BY_SAL_RANGE="UPDATE EMP SET SAL=SAL+? WHERE  SAL>=? AND SAL<=?";
	
	
	@NonNull
	@Autowired
	private JdbcTemplate jt;



	@Override
	public int getEmpsCount() {
		int count=0;
		count=jt.queryForObject(GET_EMPS_COUNT, Integer.class); //uses Simple Statement object
		//count=jt.queryForObject(GET_EMPS_COUNT, Integer.class,new Object[] {});  //uses PrepearedStatement object
		return count;
	}

	@Override
	public  String getEmpNameById(int no) {
		String name=null;
		//use DAO
		name=jt.queryForObject(GET_EMP_NAME_BY_ID,String.class,no);
		
		return name;
	}
	
	@Override
	public Map<String, Object> getEmpById(int id) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_EMP_BY_ID,id);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmpsByDesg(String desg) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList(GET_EMPS_BY_DESG, desg);
		return list;
	}
	
	@Override
	public int insert(int eno, String ename, String desg, int salary) {
		int  count=0;
		//use DAO
		count=jt.update(INSERT_EMPLOYEE, eno,ename,desg,salary);
		return count;
	}
	
	@Override
	public int delete(int eno) {
	    int count=0;
	    //use DAO
	    count=jt.update(DELETE_EMPLOYEE,eno);
		return count;
	}
	
	@Override
	public int updateSalary(int bonus, int startSalary, int endSalary) {
		int count=0;
		count=jt.update(UPDATE_EMP_SAL_BY_SAL_RANGE, bonus,startSalary,endSalary);
		return count;
	}

}
