package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
   @Autowired
	private  EmployeeRepository  empRepo;
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		System.out.println("dao class::"+empRepo.getClass());
	  List<Employee> listEntities=null;
	  List<EmployeeDTO> listDTO=new ArrayList();
	  listEntities=(List<Employee>) empRepo.findAll();
	  //covert listEnties to listDTO
	  listEntities.forEach(emp->{
		  //copy each entity to each DTO
		  EmployeeDTO dto=new EmployeeDTO();
		  BeanUtils.copyProperties(emp,dto);
		  listDTO.add(dto);
	  });
		return listDTO;
	}
	@Override
	public EmployeeDTO getEmployeeById(int id) {
		EmployeeDTO dto=null;
		Optional<Employee> optEntity=null;
		Employee entity=null;
		//use Repository
		optEntity=empRepo.findById(id);
		entity=optEntity.get();
		//convert Entity to  DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto; 
	}
	
	@Override
		public List<EmployeeDTO> getEmployeesByDesgs(String desg1, String desg2) {
		  List<EmployeeDTO> listDTO=new ArrayList();
		  List<Employee>  listEntities=null;
		 
		  //use Repository
	     listEntities=empRepo.findEmpsByDesgs(desg1, desg2);
	     listEntities.forEach(emp->{
	        EmployeeDTO dto=new EmployeeDTO();
	        BeanUtils.copyProperties(emp,dto);
	        listDTO.add(dto);
	     });
			return listDTO;
		}
	@Override
	public long getEmployeesCount() {
		long count=0;
		//use Repository
		count=empRepo.count();
		
		return count;
	}
	
	@Override
		public long getEmployeesSalariesCount() {
			long salariesTotal=0;
			salariesTotal=empRepo.findEmpsSalariesTotal();
			return salariesTotal;
		}
	
	@Override
		public String registerEmployee(EmployeeDTO dto) {
			Employee entity=null;
			//convert DTO to Entity
			entity=new Employee();
			BeanUtils.copyProperties(dto,entity);
			//use repository
			entity=empRepo.save(entity);
			if(entity==null)
				 return "employee registration failed";
			else
				 return "employee succeded";
		}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
		public String addBonusToEmployeesByDesg(String desg, float bonus) {
		int count=0;
		//use repository
		count=empRepo.updateEmpsSalByDesg(desg, bonus);
		return count+" no.of employees have  got Bonus";
		}
	

}
