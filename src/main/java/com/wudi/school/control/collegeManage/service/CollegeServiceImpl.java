package com.wudi.school.control.collegeManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.collegeManage.dao.CollegeMapper;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	CollegeMapper collegeMapper;

	@Override
	public Map<String, Object> getCollegeList() {
		HashMap<String, Object> map = new HashMap<>();
		//查询院系列表
		List<Map<String,String>> collegeList = collegeMapper.getCollegeList();
		map.put("collegeList", collegeList);
		
		return map;
	}

	@Override
	public Map<String, Object> getCollegeById(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		String id = request.getParameter("id");
		if(id==null){
			return map;
		}
		Map<String,String> college = collegeMapper.getCollegeById(id);
		map.put("college", college);
		return map;
	}

	@Override
	public Map<String, Object> getTuitionList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String,String>> tuitionList = collegeMapper.getTuitionList();
		map.put("tuitionList", tuitionList);
		return map;
	}

}
