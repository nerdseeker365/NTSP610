package com.nt.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountriesHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 Locale locales[]=null;
		 String countries[]=null;
		 int i=0;
		 //get All Locales
		 locales=Locale.getAvailableLocales();
		 countries=new String[locales.length];
		 for(Locale lcl:locales) {
			 countries[i]=lcl.getDisplayCountry();
			 i++;
		 }
		 //keep the result in request scope
		 req.setAttribute("countriesList",countries);
		 //return lvn
		return "countries";
	}

}
