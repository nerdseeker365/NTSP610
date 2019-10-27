package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;
@Component("loginValidator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCommand cmd=null;
		// type casting
		cmd=(UserCommand)target;
		if(cmd.getUser().length()==0 || cmd.getUser().equals("") || cmd.getUser()==null)
               errors.rejectValue("user","user.required");
        if(cmd.getPwd().length()==0 ||cmd.getPwd().equals("") || cmd.getPwd()==null )
        	      errors.rejectValue("pwd","pwd.required");
	}
}
