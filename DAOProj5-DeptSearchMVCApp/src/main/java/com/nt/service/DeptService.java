package com.nt.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	public List<Map<String,Object>>  findDeptsByLocations(String [] locations);

}
