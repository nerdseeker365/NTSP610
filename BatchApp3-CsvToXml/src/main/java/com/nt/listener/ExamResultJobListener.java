package com.nt.listener;


import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ExamResultJobListener implements JobExecutionListener {
    private long startTime,endTime;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		startTime=System.currentTimeMillis();

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		List<Throwable> exceptionList=null;
		endTime=System.currentTimeMillis();
		System.out.println("Job Execution time::"+(endTime-startTime)+" ms");
		
		if(jobExecution.getStatus()==BatchStatus.COMPLETED)
			System.out.println("job completed");
		if(jobExecution.getStatus()==BatchStatus.FAILED) {
			System.out.println("job  failed with errors--->");
			
			exceptionList= jobExecution.getAllFailureExceptions();
			for(Throwable th : exceptionList){
				System.err.println("exception :" +th.getLocalizedMessage());
			}
		}
		
	}
	
	
	

}
