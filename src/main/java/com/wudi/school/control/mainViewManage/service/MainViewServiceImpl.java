package com.wudi.school.control.mainViewManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.mainViewManage.dao.MainViewMapper;

@Service
public class MainViewServiceImpl implements MainViewService{

	@Autowired
	MainViewMapper  mainViewMapper;
	
	@Override
	public Map<String,Object> index(HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<>();
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies){
			if("user_pass".equals(cookie.getName())){
				String account = cookie.getValue().substring(0, cookie.getValue().indexOf("-"));
				String password = cookie.getValue().substring(cookie.getValue().indexOf("-")+1,cookie.getValue().length());
				map.put("account", account);
				map.put("password", password);
			}
		}
		//先获取校长致辞xzzc
		String xzzc = mainViewMapper.getXZZC();
		map.put("xzzc", xzzc);
		//获取院系列表
		List<Map<String, String>> CollegeList = mainViewMapper.getCollegeName();
		map.put("CollegeList", CollegeList);
		//获取新闻快讯，最新的6个
		List<Map<String, String>> newsFlash = mainViewMapper.getNewsFlash();
		map.put("newsFlash", newsFlash);
		//获取工大要闻
		List<Map<String, String>> news = mainViewMapper.getNews();
		map.put("news", news);
		//查询校园视频
		List<Map<String, String>> video = mainViewMapper.getVideo();
		map.put("video", video);
		//校园图片展示
		List<Map<String, String>> imgs4 = mainViewMapper.getImgs4();
		map.put("imgs4", imgs4);
		return map;
	}

}
