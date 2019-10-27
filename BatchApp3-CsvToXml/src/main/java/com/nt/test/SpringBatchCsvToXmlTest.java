package com.nt.test;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchCsvToXmlTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job1=null;
		JobExecution execution=null;
       //create IOC container	
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get JobLauncher
		launcher=ctx.getBean("launcher",JobLauncher.class);
		//get Job
		job1=ctx.getBean("job1",Job.class);
		try {
		//run the job
		execution=launcher.run(job1,new JobParameters());
		System.out.println("Status::"+execution.getExitStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
