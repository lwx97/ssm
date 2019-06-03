package com.wudi.school.control.infoManage.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.infoManage.dao.InfoMapper;

@Service
public class InfoServiceImpl implements InfoService{
	@Autowired
	private InfoMapper infoMapper;

	@Override
	public Map<String, Object> sendReportInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		String id = UUID.randomUUID().toString().replace("-", "");
		map2.put("id", id);
		//获取用户账号或学号
		String info_id = (String) req.getSession().getAttribute("info_id");
		map2.put("info_id", info_id);
		String report_status = req.getParameter("report_status");
		map2.put("report_status", report_status);
		map2.put("report_type", req.getParameter("report_type"));
		map2.put("noReport", req.getParameter("noReport"));
		map2.put("report_phone", req.getParameter("report_phone"));
		map2.put("report_time", req.getParameter("report_time"));
		map2.put("title", req.getParameter("title"));
		map2.put("text", req.getParameter("text"));
		int i = infoMapper.sendReportInfo(map2);
		infoMapper.updateInfo(id);
		if(i!=0){
			map.put("flag", i);
			return map;
		}
		return null;
	}
}
