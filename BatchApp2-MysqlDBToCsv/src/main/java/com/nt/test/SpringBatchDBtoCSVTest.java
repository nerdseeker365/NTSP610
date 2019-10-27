package com.nt.test;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchDBtoCSVTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job=null;
		JobExecution execution=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
try {
		//get JobLauncher
		launcher=ctx.getBean("launcher",JobLauncher.class);
		//get Job 
		job=ctx.getBean("job1",Job.class);
		//run the job
			execution=launcher.run(job,new JobParameters());
			System.out.println("Job Execution status::"+execution.getExitStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
