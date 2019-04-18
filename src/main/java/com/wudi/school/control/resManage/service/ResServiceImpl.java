package com.wudi.school.control.resManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.resManage.dao.ResMapper;

@Service
public class ResServiceImpl implements ResService{

	@Autowired
	private ResMapper resMapper;
	
	@Override
	public Map<String, Object> getResList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String, String>> list = resMapper.getResList();
		map.put("resList", list);
		return map;
	}

}
