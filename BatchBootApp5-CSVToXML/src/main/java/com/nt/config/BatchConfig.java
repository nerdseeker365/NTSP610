package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.nt.model.ExamResult;
import com.nt.processor.ExamResultProcessor;

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages="com.nt.processor")
public class BatchConfig {
	@Autowired
	private  JobBuilderFactory  jobBuilderFactory;
	@Autowired
	private  StepBuilderFactory stepBuilderFactory;
	@Autowired
	private  ExamResultProcessor  processor;
	
	
	 //ItemReader
	  @Bean
	  public FlatFileItemReader<ExamResult> reader() {
		  
	    FlatFileItemReader<ExamResult> reader; 
	    reader= new FlatFileItemReader<>();
	    
	    reader.setResource(new ClassPathResource("com/nt/csv/SuperBrains.csv"));
	    
	    reader.setLineMapper(new DefaultLineMapper<ExamResult>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {{
	        setNames(new String[]{"id","semester","dob","percentage"});
	      }});
	      
	      setFieldSetMapper(new BeanWrapperFieldSetMapper<ExamResult>() {{
	        setTargetType(ExamResult.class);
	      }});
	    }});
	    return reader;
	  }//reader()
	  
	//Item Writer
	  @Bean
	  public StaxEventItemWriter<ExamResult> writer() {
		  StaxEventItemWriter<ExamResult> writer=null;
		  Jaxb2Marshaller marshaller =null;
		  
		  writer=new StaxEventItemWriter();
		  writer.setResource(new FileSystemResource("xml/topBrains1.xml"));
		  marshaller=new Jaxb2Marshaller();
		  marshaller.setClassesToBeBound(ExamResult.class);
		  writer.setMarshaller(marshaller);
		  writer.setRootTagName("ExcellentResults");
	      return writer;
	  }//writer()
	  
	  
	  @Bean("job1")
	  public Job createJob() {
	    return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer())
	        .flow(createStep()).end().build();
	  }
	  
	  @Bean("step1")
	  public Step createStep() {
	    return stepBuilderFactory.get("step1").<ExamResult, ExamResult>chunk(1).reader(reader())
	        .processor(processor).writer(writer()).build();
	  }
	  

	

}
