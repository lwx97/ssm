package com.wudi.school.control.collegeManage.dao;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
	
	/**
	 * 查询院系列表
	 * @return
	 */
	List<Map<String, String>> getCollegeList();

	Map<String, String> getCollegeById(String id);

	List<Map<String, String>> getTuitionList();

}
