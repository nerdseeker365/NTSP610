package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface DeptDAO {
	public  List<Map<String,Object>> searchDeptsByLoc(String cond);
	

}
