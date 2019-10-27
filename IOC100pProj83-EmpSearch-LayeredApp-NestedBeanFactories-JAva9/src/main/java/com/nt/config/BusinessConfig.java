package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages= {"com.nt.dao","com.nt.service"})
@PropertySource("classpath:com/nt/commons/jdbc.properties")
public class BusinessConfig {
	/*@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.dbuser}")
	private String user;
	@Value("${jdbc.dbpwd}")
	private String pwd;
*/
	@Autowired
	private  Environment env;
	 
	
	@Bean(name="apacheDs")
	public   DataSource createDS() {
		 BasicDataSource ds=null;
		 ds=new  BasicDataSource();
		 ds.setDriverClassName(env.getProperty("jdbc.driver"));
		 ds.setUrl(env.getProperty("jdbc.url"));
		 ds.setUsername(env.getProperty("jdbc.dbuser"));
		 ds.setPassword(env.getProperty("jdbc.dbpwd"));
		 System.out.println(env.getProperty("JAVA_HOME"));
		 return ds;
	}

}
