package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
@PropertySource("classpath:com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	@Bean(name="hkDs")
	public DataSource  createDS() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	@Bean(name="jt")
	public   JdbcTemplate  createJdbcTemplate() {
		return new JdbcTemplate(createDS());
	}

}
