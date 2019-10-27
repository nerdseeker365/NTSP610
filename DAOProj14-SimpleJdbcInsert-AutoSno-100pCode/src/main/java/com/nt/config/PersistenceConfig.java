package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value="classpath:com/nt/commons/jdbc.properties")
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	@Autowired
	private Environment  env;
	
	@Bean(name="hkDS")
	public  DataSource createDS() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.user"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.pwd"));
		return hkDs;
	}
	
	@Bean(name="template")
	public  JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}
	
	@Bean(name="sji")
	public  SimpleJdbcInsert createSJI() {
		return new SimpleJdbcInsert(createDS());
	}

}
