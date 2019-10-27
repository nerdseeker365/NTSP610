package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	
	@Bean(name="oraXADs")
	public   AtomikosDataSourceBean  createXADSForOracle() {
		Properties props=null;
		AtomikosDataSourceBean  xaDs=new AtomikosDataSourceBean();
		xaDs.setUniqueResourceName("xaOra");
		xaDs.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.put("databaseName","xe");
		props.put("user","system");
		props.put("password","manager");
		props.put("URL","jdbc:oracle:thin:@localhost:1521:xe");
		xaDs.setXaProperties(props);
		xaDs.setPoolSize(10);
		return xaDs;
	}
	
	@Bean(name="mysqlXADs")
	public   AtomikosDataSourceBean  createXADsForMySQL() {
		Properties props=null;
		AtomikosDataSourceBean  xaDs=new AtomikosDataSourceBean();
		xaDs.setUniqueResourceName("xaMysql");
		xaDs.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		props=new Properties();
		props.put("databaseName","ntsp610DB");
		props.put("user","root");
		props.put("password","root");
		props.put("URL","jdbc:mysql:///ntsp610DB");
		xaDs.setXaProperties(props);
		xaDs.setPoolSize(10);
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
