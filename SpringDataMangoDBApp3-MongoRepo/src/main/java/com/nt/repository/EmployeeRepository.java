package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
