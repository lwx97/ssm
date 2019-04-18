package com.wudi.school.control.afficheManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.afficheManage.dao.AfficheMapper;

@Service
public class AfficheServiceImpl implements AfficheService{
	
	@Autowired
	private AfficheMapper afficheMapper;
	
	@Override
	public Map<String, Object> getAfficheList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String, String>> list = afficheMapper.getAfficheList();
		map.put("afficheList", list);
		return map;
	}

}
