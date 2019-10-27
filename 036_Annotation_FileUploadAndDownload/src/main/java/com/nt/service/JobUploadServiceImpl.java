package com.nt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.JobBo;
import com.nt.command.JobCommand;
import com.nt.dao.JobUploadDao;
import com.nt.dto.JobDto;

@Service("upservice")
public class JobUploadServiceImpl implements JobUploadService {

	@Autowired
	private JobUploadDao dao;

	/******************* Upload Operation **************************/
	@Override
	public String up(String location, JobCommand cmd, JobDto dto) throws Exception {

		InputStream is1 = null, is2 = null;
		OutputStream os1 = null, os2 = null;
		File file = null;
		String fileName1 = null, fileName2 = null;
		int cnt = 0;
		String msg = null;
		JobBo bo = null;

		// get the File Object
		file = new File(location);

		// check
		if (!file.exists()) {
			file.mkdirs();
		}

		// get the input Streams
		is1 = cmd.getPhoto().getInputStream();
		is2 = cmd.getResume().getInputStream();

		// get the File Names
		fileName1 = cmd.getPhoto().getOriginalFilename();
		fileName2 = cmd.getResume().getOriginalFilename();

		// remove Spaces From File Name
		fileName1.replaceAll("\\s", "_");
		fileName2.replaceAll("\\s", "_");
		System.out.println(fileName1);
		System.out.println(fileName2);

		// get the Output Streams
		os1 = new FileOutputStream(file.getAbsolutePath() + "/" + fileName1);
		os2 = new FileOutputStream(file.getAbsolutePath() + "/" + fileName2);

		// copy from DTO to BO
		bo = new JobBo();
		BeanUtils.copyProperties(dto, bo);

		// use Dao
		cnt = dao.insert(bo);

		// check
		if (cnt == 0) {
			msg = "Job Registration Failed...!";
		} else {
			// Copy Contents From Source To Destination
			IOUtils.copy(is1, os1);
			IOUtils.copy(is2, os2);
			msg = "Job Registration Suceeded...!";
		} // else
		return msg;
	}// up
	
	

	/******************* Fetch File Path Operation **************************/

	@Override
	public List<String> fetchFilePath() {

		List<JobBo> listBo = null;
		List<String> fn = new ArrayList<String>();
		// use Dao
		listBo = dao.getFilePath();
		// copy
		listBo.forEach(bo -> {
			fn.add(FilenameUtils.getName(bo.getPhotopath().toString()));
			fn.add(FilenameUtils.getName(bo.getResumepath().toString()));
			// System.out.println(fn);
		});
		return fn;

		/*
		 * String name1 = FilenameUtils.getName("/ab/cd/xyz.txt"); String name2 =
		 * FilenameUtils.getName("c:\\ab\\cd\\xyz.txt");
		 */

		/*
		 * Path p = Paths.get("c:\\temp\\1.txt"); String fileName =
		 * p.getFileName().toString(); String directory = p.getParent().toString();
		 */

	}// fetchFilePath

}// class
