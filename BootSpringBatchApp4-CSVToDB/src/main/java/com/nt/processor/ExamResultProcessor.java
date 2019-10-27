package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
@Component
public class ExamResultProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		OExamResult result=null;
		if(item.getPercentage()>95) {
			result=new OExamResult();
			result.setId(item.getId());
			result.setDob(java.sql.Date.valueOf(item.getDob()));
			result.setPercentage(item.getPercentage());
			result.setSemester(item.getSemester());
			return result;
		}
     		
		else
			return null;
	}

}
