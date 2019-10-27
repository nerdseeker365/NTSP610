package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.JobBo;


@Repository("udao")
public class JobUploadDaoImpl implements JobUploadDao {
	
	private static final String INSERT_QUERY="INSERT INTO UD VALUES(UD1.NEXTVAL,?,?,?,?)";
	private static final String GET_PATH="SELECT PHOTOPATH , FILEPATH FROM UD";
	@Autowired
	private JdbcTemplate jt;
	
	
	@Override
	public int insert(JobBo bo) {
		int count=0;
		
		count=jt.update(INSERT_QUERY, bo.getName() , bo.getAddress() , bo.getPhotopath() , bo.getResumepath());
		
		return count;
	}//insert



	@Override
	public List<JobBo> getFilePath() {
		
		List<JobBo> listBo=null;
		
		listBo=jt.query(GET_PATH, new PathExtractor());
		
		return listBo;
	}
	
	private class PathExtractor implements ResultSetExtractor<List<JobBo>>{
		@Override
		public List<JobBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			JobBo bo=null;
			List<JobBo> listbo=new ArrayList<JobBo>();
			while(rs.next()) {
				
				bo=new JobBo();
				bo.setPhotopath(rs.getString(1));
				bo.setResumepath(rs.getString(2));
				
				listbo.add(bo);
				
			}//while
			return listbo;
		}///extractData
	}//inner class
	
	
}//class
