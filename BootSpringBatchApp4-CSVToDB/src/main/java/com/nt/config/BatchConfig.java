package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
import com.nt.processor.ExamResultProcessor;

@Configuration
@ComponentScan(basePackages="com.nt.processor")
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private DataSource ds;
	@Autowired
	private  ExamResultProcessor processor;
	@Autowired
	private  JobBuilderFactory jobFactory;
	@Autowired
	private  StepBuilderFactory stepFactory;
	
	
	 //ItemReader
	  @Bean
	  public FlatFileItemReader<IExamResult> reader() {
		  
	    FlatFileItemReader<IExamResult> reader; 
	    reader= new FlatFileItemReader<>();
	    
	    reader.setResource(new FileSystemResource("csv/superBrains.csv"));
	    
	    reader.setLineMapper(new DefaultLineMapper<IExamResult>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {{
	        setNames(new String[]{"id","dob","percentage","semester"});
	      }});
	      
	      setFieldSetMapper(new BeanWrapperFieldSetMapper<IExamResult>() {{
	        setTargetType(IExamResult.class);
	      }});
	    }});
	    return reader;
	  }//reader()
	  
	  
	//Item Writer
	  @Bean
	  public JdbcBatchItemWriter<OExamResult> writer() {
	    JdbcBatchItemWriter<OExamResult> writer =null;
	    writer=	new JdbcBatchItemWriter();

	    writer.setDataSource(ds);
	    writer.setSql("INSERT INTO EXAM_RESULT1(ID,DOB,PERCENTAGE,SEMESTER)  VALUES (:id,:dob,:percentage,:semester)");
	    writer.setItemSqlParameterSourceProvider(
	        new BeanPropertyItemSqlParameterSourceProvider<OExamResult>());
	    return writer;
	  }//writer()
	  
	  //create Step
	  @Bean(name="step1")
	  public   Step  createStep() {
		  return  stepFactory.get("step1").<IExamResult,OExamResult>chunk(1).reader(reader()).processor(processor).writer(writer()).build();
	  }
	  
	  //create JOB
	  @Bean("job1")
	  public Job createJob() {
	    return jobFactory.get("job1").incrementer(new RunIdIncrementer())
	        .flow(createStep()).end().build();
	  }
	  
	

}
