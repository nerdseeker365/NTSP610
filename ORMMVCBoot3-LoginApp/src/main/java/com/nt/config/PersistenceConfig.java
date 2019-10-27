package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.UserHLO;



@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	@Autowired
	private DataSource ds;
	
	@Bean(name="sesfact")
	public   LocalSessionFactoryBean  createLocalSFB() {
		LocalSessionFactoryBean bean=null;
		Properties props=null;
		bean=new LocalSessionFactoryBean();
		bean.setDataSource(ds);
		bean.setAnnotatedClasses(new Class[] {UserHLO.class});
		props=new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		props.put("show_sql", "true");
		props.put("format_sql","true");
		bean.setHibernateProperties(props);
		return bean;
		
	}
	
	@Bean
	@Primary
	public  SessionFactory   createSesFact() {
	   return  createLocalSFB().getObject();
	}
	
	@Bean
	public   HibernateTemplate createHT() {
		return new HibernateTemplate(createSesFact());
	}

}
