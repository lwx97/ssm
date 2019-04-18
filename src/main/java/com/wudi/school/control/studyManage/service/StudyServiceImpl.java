package com.wudi.school.control.studyManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.studyManage.dao.StudyMapper;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	private StudyMapper studyMapper;
	
	@Override
	public Map<String, Object> getStudySchoolList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String, String>> list = studyMapper.getStudySchoolList();
		map.put("studySchoolList", list);
		return map;
	}

}
