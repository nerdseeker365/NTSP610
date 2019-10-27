package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
@PropertySource("classpath:com/nt/commons/info.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	
	@Bean
	public JndiObjectFactoryBean  createJOFB() {
		JndiObjectFactoryBean jofb=null;
		DataSource ds=null;
		
		jofb=new JndiObjectFactoryBean();
		//jofb.setJndiName("java:/comp/env/DsJndi");
		jofb.setJndiName(env.getProperty("ds.jndi"));
		return jofb;
	}
	
	@Bean
	public JdbcTemplate createJT(JndiObjectFactoryBean jfb) {
		return new JdbcTemplate((DataSource) jfb.getObject());
	}
	
	
	/*@Bean(name="dataSource")
	public JndiObjectFactoryBean  createJOFB() {
		JndiObjectFactoryBean jofb=null;
		DataSource ds=null;
		
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}*/
	
	/*	@Bean
		   public  DataSource  createDs() {
			  JndiDataSourceLookup  jdsl=null;
			  DataSource ds=null;
			  jdsl=new JndiDataSourceLookup();
			  ds=jdsl.getDataSource("java:/comp/env/DsJndi");
			  return ds;
		   }
		
		@Bean
		public   JdbcTemplate  createJT() {
			return new JdbcTemplate(createDs());
		} */
	
	/*@Bean
	   public  DataSource  createDs() {
		  JndiDataSourceLookup  jdsl=null;
		  DataSource ds=null;
		  jdsl=new JndiDataSourceLookup();
		  ds=jdsl.getDataSource("java:/comp/env/DsJndi");
		  return ds;
	   }
	
	@Bean
	public   JdbcTemplate  createJT(DataSource ds) {
		return new JdbcTemplate(ds);
	}*/
	
	/*	@Bean
		@Primary
		public   DataSource  createDs() {
			return  (DataSource) createJOFB().getObject();
		}*/
	
	
	/*//@Bean(autowire=Autowire.BY_TYPE)
	@Bean(autowire=Autowire.BY_NAME)
	public   JdbcTemplate  createJT() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate();
		return jt;
	} */
	
	/*@Bean
	public   JdbcTemplate  createJT() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate(createDs());
		return jt;
	} 
	*/
	
	/*	@Bean
		public   JdbcTemplate  createJT() {
			JdbcTemplate jt=null;
			jt=new JdbcTemplate((DataSource) createJOFB().getObject());
			return jt;
		} 
	*/
}
