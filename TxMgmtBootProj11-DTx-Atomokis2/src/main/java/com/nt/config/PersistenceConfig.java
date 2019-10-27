package com.nt.config;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	
	@Bean(name="oraXADs")
	@ConfigurationProperties(prefix="spring.jta.atomikos.datasource.first")
	public   AtomikosDataSourceBean  createXADSForOracle() {
		AtomikosDataSourceBean  xaDs=new AtomikosDataSourceBean();
		return xaDs;
	} 
	
	@Bean(name="mysqlXADs")
	@ConfigurationProperties(prefix="spring.jta.atomikos.datasource.second")
	public   AtomikosDataSourceBean  createXADsForMySQL() {
		Properties props=null;
		AtomikosDataSourceBean  xaDs=new AtomikosDataSourceBean();
		return xaDs;
	}
	
	@Bean(name="template1")
	public   JdbcTemplate createOraJt() {
		return new JdbcTemplate(createXADSForOracle());
	}
	
	@Bean(name="template2")
	public   JdbcTemplate createMysqlJt() {
		return new JdbcTemplate(createXADsForMySQL());
	}


}
