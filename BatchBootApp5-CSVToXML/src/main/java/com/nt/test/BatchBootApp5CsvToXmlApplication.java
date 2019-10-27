package com.nt.test;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class BatchBootApp5CsvToXmlApplication {
	@Autowired
	private static  JobLauncher launcher;

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobExecution execution=null;
		Job job=null;
		ctx=SpringApplication.run(BatchBootApp5CsvToXmlApplication.class, args);
		//get Bean
		job=ctx.getBean("job1",Job.class);
		try {
			execution=launcher.run(job,new JobParameters());
			System.out.println("status::"+execution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container 
		((ConfigurableApplicationContext) ctx).close();
		
	}

}

