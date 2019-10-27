package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UploadCommand;
@Controller
public class UploadController {
	
	@GetMapping(value="/register.htm")
	public   String   showForm(@ModelAttribute("uplCmd") UploadCommand cmd) {
		return "jobseeker_register";
	}
	
	
	@PostMapping(value="/register.htm")
	public   String  processForm(@ModelAttribute("uplCmd")UploadCommand  cmd,
			                                             Map<String,Object> map,HttpServletRequest req )throws Exception {
		InputStream is1=null,is2=null;
		String  fname1=null,fname2=null;
		OutputStream os1=null,os2=null;
		ServletContext sc=null;
		File uplLoc=null;
		//get ServletContext obj
		sc=req.getServletContext();
		//checke the avaliable upload Folder Location
		uplLoc=new File(sc.getInitParameter("uplLocation"));
		if(!uplLoc.exists()) {
			uplLoc.mkdir();
		}
		
		
		//get InputStreams pointing to uploaded files
		is1=cmd.getPhotoFile().getInputStream();
		is2=cmd.getResumeFile().getInputStream();
		//get uploaded file names
		fname1=cmd.getPhotoFile().getOriginalFilename();
		fname2=cmd.getResumeFile().getOriginalFilename();
		//create OutputStream pointing dest files
		os1=new FileOutputStream(uplLoc.getAbsolutePath()+"/"+fname1);
		os2=new FileOutputStream(uplLoc.getAbsolutePath()+"/"+fname2);
		//copy content from source to dest using streams
		IOUtils.copy(is1,os1);
		IOUtils.copy(is2,os2);
		
		//keep uploaded file names in model Attributes
		map.put("file1",fname1);
		map.put("file2",fname2);
		//return   result page lvn
		return "upload_success";
	}
}
