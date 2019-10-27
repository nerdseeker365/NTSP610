package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;


@Configuration
public class AopConfig {
	
	  @Bean(name="dTx")
	  public  UserTransactionImp  createUserTx()throws Exception {
		  UserTransactionImp dtx=null;
		  dtx=new UserTransactionImp();
		  dtx.setTransactionTimeout(300);
		  return dtx;
		  
	  }
	  
	  @Bean(name="dTxMgmr")
	  public  UserTransactionManager  createUserTxMgmr()throws Exception {
		  UserTransactionManager dtxMgmr=null;
		  dtxMgmr=new UserTransactionManager();
		  dtxMgmr.setForceShutdown(true);
		  return dtxMgmr;
	  }
	  
	  @Bean(name="jtaTxMgmr")
	  public   JtaTransactionManager  createJtaTxMgmr() throws Exception{
		  JtaTransactionManager  jtaMgmr=null;
		  jtaMgmr=new JtaTransactionManager();
		  jtaMgmr.setTransactionManager(createUserTxMgmr());
		  jtaMgmr.setUserTransaction(createUserTx());
		  return jtaMgmr;
	  }

}
