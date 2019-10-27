package com.nt.adapter;

import java.sql.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SqlDateAdapter extends XmlAdapter<String, Date> {

	@Override
	public Date unmarshal(String value) throws Exception {
	     
		return  java.sql.Date.valueOf(value);
	}

	@Override
	public String marshal(Date date) throws Exception {
		return date.toString();
	}

}
