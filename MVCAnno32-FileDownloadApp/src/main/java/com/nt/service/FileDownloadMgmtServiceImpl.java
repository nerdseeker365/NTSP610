package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Named("downloadMgmtService")
public class FileDownloadMgmtServiceImpl implements FileDownloadMgmtService {

	@Override
	public List<String> fetchFilesList(String location) {
		 File  storeLoc=null;
		 File[] files=null;
		 List<String> lof=null;
		 storeLoc=new File(location);
		 lof=new ArrayList();
		 if(storeLoc.exists()) {
			 files=storeLoc.listFiles();
			 for(File f:files) {
				 if(f.isFile()) {
					 lof.add(f.getName());
				 }//if
			 }//for
		 }//if
		return lof;
	}//method

}//class
