package com.wudi.school.control.adminManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.adminManage.dao.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	
	@Override
	public Map<String, Object> getInfo() {
		HashMap<String, Object> map = new HashMap<String,Object>();
		List<Map<String, String>> info = adminMapper.getInfo();
		map.put("list", info);
		return map;
	}


	@Override
	public Map<String, Object> updatePower(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			HashMap<String, String> hashMap = new HashMap<>();
			String id = req.getParameter("id");
			String role = adminMapper.getUser(id);
			if(role.equals("2")) {
				role = "3";
			}else {
				role = "2";
			}
			hashMap.put("role", role);
			hashMap.put("id", id);
			adminMapper.updatePower(hashMap);
		}catch (Exception e) {
			return null;
		} 
		map.put("flag", "true");
		return map;
	}


	@Override
	public Map<String, Object> getMenuType() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String,String>> list = adminMapper.getMenuType();
		map.put("mt", list);
		return map;
	}


	@Override
	public Map<String, Object> getMenu(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String id = req.getParameter("id");
		List<Map<String,String>> mlist = adminMapper.getMenu(id);
		map.put("mList", mlist);
		return map;
	}


	@Override
	public Map<String, Object> saveInfo(HttpServletRequest req) {
	
		HashMap<String, Object> map = new HashMap<>();
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String txt = req.getParameter("txt");
			HashMap<String, String> map1 = new HashMap<>();
			map1.put("id", id);
			map1.put("txt",txt);
			adminMapper.saveInfo(map1);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		map.put("flag", "ture");
		return map;
	}

}
