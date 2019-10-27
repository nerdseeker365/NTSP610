package com.nt.dao;

import java.util.List;

import com.nt.bo.JobBo;

public interface JobUploadDao {
	public int insert(JobBo bo);
	public List<JobBo> getFilePath();
}
