package com.nt.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.nt.service.BankService;

@Configuration
public class AOPConfig {
	@Resource
	private BankService service;
	@Resource
	private DataSourceTransactionManager txMgmr;

	@Bean(name="tpfb")
	public    TransactionProxyFactoryBean createTFB() {
		 TransactionProxyFactoryBean tpfb=null;
		 Properties props=null;
		 tpfb=new TransactionProxyFactoryBean();
		 tpfb.setTarget(service);
		 tpfb.setTransactionManager(txMgmr);
		 props=new Properties();
		 props.put("transferMoney","PROPAGATION_REQUIRED");
		 tpfb.setTransactionAttributes(props);
		 return tpfb;
	}
	

}
