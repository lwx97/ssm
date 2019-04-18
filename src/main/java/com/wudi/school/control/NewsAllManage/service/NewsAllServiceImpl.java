package com.wudi.school.control.NewsAllManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.NewsAllManage.dao.NewsAllMapper;

@Service
public class NewsAllServiceImpl implements NewsAllService {

	@Autowired
	NewsAllMapper newsAllMapper;
	
	/**
	 * 获取工大要闻
	 */
	@Override
	public Map<String, Object> getNewsList() {
		HashMap<String, Object> map = new HashMap<>();
		//查询要闻类型
		List<Map<String, String>> typeList = newsAllMapper.getNewsTypeList("2");
		map.put("typeList", typeList);
		//查询类型下的要闻
		List<Map<String, String>> newsList = newsAllMapper.getNewsList(typeList.get(0).get("id"));
		map.put("newsList", newsList);
		return map;
	}

	@Override
	public Map<String, Object> getNewsById(HttpServletRequest req) {
		String id = req.getParameter("id");
		HashMap<String,Object> map = new HashMap<>();
		if(id==null){
			return map;
		}
		Map<String,String> news= newsAllMapper.getNewsById(id);
		map.put("news", news);
		return map;
	}

	@Override
	public Map<String, Object> getNewsListByTypeId(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String typeid = req.getParameter("typeid");
		if(typeid == null)
			return map;
		List<Map<String, String>> newsList = newsAllMapper.getNewsList(typeid);
		map.put("newsList", newsList);
		return map;
	}

	@Override
	public Map<String, Object> getNewsFlashList() {
		HashMap<String, Object> map = new HashMap<>();
		//查询快讯类型
		List<Map<String, String>> typeList = newsAllMapper.getNewsTypeList("1");
		map.put("typeList", typeList);
		//查询类型下的要闻
		List<Map<String, String>> newsFlashList = newsAllMapper.getNewsFlashList(typeList.get(0).get("id"));
		map.put("newsFlashList", newsFlashList);
		return map;
	}

	@Override
	public Map<String, Object> getNewsFlashListByTypeId(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String typeid = req.getParameter("typeid");
		if(typeid == null)
			return map;
		List<Map<String, String>> newsList = newsAllMapper.getNewsFlashList(typeid);
		map.put("newsFlashList", newsList);
		return map;
	}

	@Override
	public Map<String, Object> getNewsFlashById(HttpServletRequest req) {
		String id = req.getParameter("id");
		HashMap<String,Object> map = new HashMap<>();
		if(id==null){
			return map;
		}
		Map<String,String> news= newsAllMapper.getNewsFlashById(id);
		map.put("newsFlash", news);
		return map;
	}

}
