package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("from  Employee where desg in(:job1,:job2)")
	 public   List<Employee>  findEmpsByDesgs(@Param("job1")String desg1,@Param("job2")String desg2);
	
	@Query("select sum(salary) from  Employee")
	public   long  findEmpsSalariesTotal();
	
	@Query("update Employee set salary=salary+:bns where desg=:job")
	@Modifying
	public  int  updateEmpsSalByDesg(@Param("job")String desg,@Param("bns") float bouns);
	
}
