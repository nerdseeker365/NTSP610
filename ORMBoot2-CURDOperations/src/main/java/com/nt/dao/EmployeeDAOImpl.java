package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.EmployeeHLO;

import oracle.net.aso.r;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String HQL_GET_EMP_SAL_BY_NO="SELECT salary FROM EmployeeHLO WHERE eid=:id";
	private static final String HQL_UPDATE_EMP_SAL_BY_NO="UPDATE EmployeeHLO SET salary=? WHERE eid=?";
	private static final String HQL_DELETE_EMPS_BY_SAL_RANGE="DELETE FROM EmployeeHLO WHERE salary>=:min AND salary<=:max";
	@Autowired
	private  HibernateTemplate ht;

	public EmployeeHLO getEmpByNo(int no) {
		EmployeeHLO hlo=null;
		//get Object
		hlo=ht.get(EmployeeHLO.class, no);
		return hlo;
	}

	public int insertEmp(EmployeeHLO hlo) {
		int idVal=0;
		ht.setCheckWriteOperations(false);
		idVal=(Integer) ht.save(hlo);
		return idVal;
	}

	public float getEmpSalaryByNo(int no) {
		List<Float> list=null;
	    list=(List<Float>) ht.findByNamedParam(HQL_GET_EMP_SAL_BY_NO, "id",no);
		return list.get(0);
	}
	
	public int updateEmpSalaryByNo(int no, float newSalary) {
		int count=0;
		count=ht.bulkUpdate(HQL_UPDATE_EMP_SAL_BY_NO, newSalary,no);
		return count;
	}
	
	public int deleteEmpsBySalaryRange(final float startSalary, final float endSalary) {
		int count=0;
		count=ht.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session ses) throws HibernateException {
				 Transaction tx=null;
				 Query<r> query=null;
				 int result=0;
				 boolean flag=false;
				 try {
				   //beginTrassaction	 
				  tx=ses.beginTransaction();
	   			   //prepare Query object having HQL Query
				  query=ses.createQuery(HQL_DELETE_EMPS_BY_SAL_RANGE);
				  //set query param values
				  query.setParameter("min",startSalary);
				  query.setParameter("max",endSalary);
				  //execuite Query
				  result=query.executeUpdate();
				  flag=true;
				 }//try
				 catch(HibernateException he) {
					 flag=false;
					 throw he;
				 }
				 finally {
					 if(flag)
						 tx.commit();
					 else
						 tx.rollback();
				 }
				return result;
			}//method
			
		}//anonymous inner class
		); //execute
		return count;
	}//method

}//class
