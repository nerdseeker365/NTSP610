package com.nt.service;

import java.util.List;

import com.nt.command.JobCommand;
import com.nt.dto.JobDto;

public interface JobUploadService {
	public String up(String location, JobCommand cmd, JobDto dto) throws Exception;
	public List<String> fetchFilePath();
}
