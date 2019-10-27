package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.nt.repository.EmployeeRepository;

@Configuration
@ComponentScan(basePackages="com.nt.service")
@EnableMongoRepositories(basePackageClasses=EmployeeRepository.class)
public class AppConfig {

}
