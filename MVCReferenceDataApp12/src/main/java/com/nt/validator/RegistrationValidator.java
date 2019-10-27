package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.RegisterCommand;

public class RegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return  clazz.isAssignableFrom(RegisterCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterCommand cmd=null;
		System.out.println("RegistrationValidator.validate(-,-)");
		cmd=(RegisterCommand)target;
		//server side form validation logics
		if(cmd.getName().length()==0)
			errors.rejectValue("name", "name.required");
		if(cmd.getAddrs().length()==0)
			errors.rejectValue("addrs", "addrs.required");
		if(cmd.getCountry().contains("---"))
			errors.rejectValue("country", "country.required");
		if( cmd.getCourses()==null || cmd.getCourses().length==0) 
			errors.rejectValue("courses", "courses.required");
		if(cmd.getHobies()==null || cmd.getHobies().length==0)
			errors.rejectValue("hobies", "hobies.required");
		
		
		
		
	}

}
