package com.wudi.school.control.knowManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.knowManage.dao.KnowMapper;

@Service
public class KnowServiceImpl implements KnowSerivce {

	@Autowired
	private KnowMapper knowMapper;
	
	/**
	 * 查询了解学校模块下的所属子模块
	 */
	@Override
	public Map<String, Object> getKnowSchoolList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String,String>> list = knowMapper.getKnowSchoolList();
		map.put("knowSchoolList", list);
		return map;
	}

}
