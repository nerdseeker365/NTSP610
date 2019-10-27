package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.JobUploadService;

@Controller
public class DownloadController {

	@Autowired
	private JobUploadService service;

	@RequestMapping(value = "/getdownload.htm")
	public String showDownload(Map<String, Object> map) {

		List<String> filelist = null;
		// use Service
		filelist = service.fetchFilePath();
		// System.out.println(filelist);
		// put result in Model Attribute
		map.put("flist", filelist);
		return "downdef";
	}// showDownload

	@RequestMapping(value = "/download.htm")
	public void processDownload(@RequestParam("filename") String filename, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		ServletContext sc = null;
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		String location = null;

		// get ServletContext Object , Location , FileName
		sc = req.getServletContext();
		location = sc.getInitParameter("upLoc");

		// Locate The File To Be Downloaded
		file = new File(location + "/" + filename);
		System.out.println(file.getAbsolutePath());
		
		// get the length of the file and make it as Response Content Length
		res.setContentLengthLong(file.length());

		// now create InpputStream Pointing To The File
		is = new FileInputStream(file);

		// create OuputStream Pointing To Response Object
		os = res.getOutputStream();
		
		
		// make The Browser to get the received file as Downloadable file
		res.addHeader("Content-Disposition", "attachment;filename=" + filename);

		// Copy The File Content To Response Object
		IOUtils.copy(is, os);

		// is.close();
		// os.close();
	}// processDownload

}// controller
