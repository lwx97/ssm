package com.wudi.school.control.homeManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.homeManage.dao.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public Map<String, Object> getHomeSchoolList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String,String>> list = homeMapper.getHomeSchoolList();
		map.put("homeSchoolList", list);
		return map;
	}

}
