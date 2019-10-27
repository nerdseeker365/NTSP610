package com.nt.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.JobCommand;
import com.nt.dto.JobDto;
import com.nt.service.JobUploadService;

@Controller
public class JobUploadController {

	@Autowired
	private JobUploadService service;

	@GetMapping(value = "/upload.htm")
	public String showHome(@ModelAttribute("udCmd") JobCommand cmd) {

		return "homedef";
	}// showHome

	@PostMapping(value = "/upload.htm")
	public String upLoad(Map<String, Object> map, @ModelAttribute("udCmd") JobCommand cmd, HttpServletRequest req)
			throws Exception {

		ServletContext sc = null;
		JobDto dto = null;
		String location = null;
		String msg = null;

		// get the Objects
		sc = req.getServletContext();
		location = sc.getInitParameter("upLoc");

		// Copy values To Dto
		dto = new JobDto();
		dto.setName(cmd.getName());
		dto.setAddress(cmd.getAddress());
		dto.setPhotopath(location + "/" + cmd.getPhoto().getOriginalFilename());
		dto.setResumepath(location + "/" + cmd.getResume().getOriginalFilename());

		System.out.println(dto.getPhotopath());
		System.out.println(dto.getResumepath());

		// use Service
		msg = service.up(location, cmd, dto);

		map.put("msg", msg);
		map.put("file1", cmd.getPhoto().getOriginalFilename());
		map.put("file2", cmd.getResume().getOriginalFilename());

		return "resdef";
	}// onSubmit

}// controller
