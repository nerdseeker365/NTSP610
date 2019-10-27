package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.FileDownloadMgmtService;
@Controller
public class FileDownloadController {
	
	@Resource
	private  FileDownloadMgmtService  service;
	
	@RequestMapping("/welcome.htm")
	public   String  showHome(Map<String,Object> map,HttpServletRequest req) {
		List<String>  filesList;
		ServletContext sc=null;
		String location=null;
		//get Context param value
		sc=req.getServletContext();
		location=sc.getInitParameter("uplLocation");
		//use Service
		filesList=service.fetchFilesList(location);
		//put in model attribute
		map.put("filesList",filesList);
		return "home";
	}
	
	@RequestMapping("/download.htm")
	public  void   download(@RequestParam("fname")String fileName,
			                                     HttpServletRequest  req,
			                                     HttpServletResponse res)throws Exception {
		ServletContext sc=null;
		String location=null;
		File file=null;
		InputStream is=null;
		OutputStream os=null;
		//get ServletContext obj
		sc=req.getServletContext();
		//get Context param value
		location=sc.getInitParameter("uplLocation");
		//Locate the file  to be downloaded
		file=new File(location+"/"+fileName);
		//get the length of the file and make it as  response content length
		res.setContentLengthLong(file.length());
		//get MIME of the file and make it as response content type
		res.setContentType(sc.getMimeType(location+"/"+fileName));
		//make browser make recieved output as download file
		res.addHeader("Content-Disposition","attachment;fileName="+fileName);
		//create InputStream pointing to file
		is=new FileInputStream(file);
		//create output stream poiting to response obj
		os=res.getOutputStream();
		//copy file content to response object
		IOUtils.copy(is,os);
		//close steams
		os.close();
		is.close();
		
		
	}
	

}
