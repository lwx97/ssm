package com.wudi.school.control.collegeManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CollegeService {

	Map<String,Object> getCollegeList();

	Map<String,Object> getCollegeById(HttpServletRequest request);

	Map<String,Object> getTuitionList(HttpServletRequest request);

}
