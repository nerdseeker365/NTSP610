package com.nt.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguagesHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 Locale locales[]=null;
		 String lang[]=null;
		 int i=0;
		 //get All Locales
		 locales=Locale.getAvailableLocales();
		 lang=new String[locales.length];
		 for(Locale lcl:locales) {
			 lang[i]=lcl.getDisplayLanguage();
			 i++;
		 }
		 //keep the result in request scope
		 req.setAttribute("langList",lang);
		 //return lvn
		return "lang";
	}

}
