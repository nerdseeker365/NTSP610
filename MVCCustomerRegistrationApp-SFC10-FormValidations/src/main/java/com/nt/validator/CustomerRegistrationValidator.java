package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.CustomerCommand;

public class CustomerRegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//return clazz==CustomerCommand.class;
		return clazz.isAssignableFrom(CustomerCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("CustomerRegistrationValidator.validate()");
		CustomerCommand cmd=null;
		String vstatus=null;
		 //type casting
		cmd=(CustomerCommand)target;
		//get vflag value to enable or disable server side form validations
		vstatus=cmd.getVflag();
		if(vstatus.equalsIgnoreCase("off")) {
			System.out.println("Server side form validation logics...");
		//required rule
		if(cmd.getCname()==null ||cmd.getCname().equals("") || cmd.getCname().length()==0)
			errors.rejectValue("cname","customer.name.required");
		
		 if(cmd.getCadd()==null || cmd.getCadd().equals("") ||cmd.getCadd().length()==0)
			errors.rejectValue("cadd","customer.addrs.required");
		 else if(cmd.getCadd().length()<10)
			 errors.rejectValue("cadd","customer.addrs.minlen");
		 
		 if(cmd.getMobileNo()==null)
				errors.rejectValue("mobileNo","customer.mobile.required");
		 else if(cmd.getMobileNo().toString().length()!=10)
			 errors.rejectValue("mobileNo","customer.mobile.length");
		 
		 if(cmd.getBillAmt()==null)
				errors.rejectValue("billAmt","customer.billAmt.required");
		 else if(cmd.getBillAmt()<=0 || cmd.getBillAmt()>10000)
				errors.rejectValue("billAmt","customer.billAmt.range");
		}
	}//validate(-,-)
}//class
