package com.wudi.school.control.infoManage.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
		infoMapper.updateInfo(info_id);
		if(i!=0){
			map.put("flag", i);
			return map;
		}
		return null;
	}

	@Override
	public Map<String, Object> daikuan(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			req.setCharacterEncoding("UTF-8");
			Map<String, String> map2 = new HashMap<>();
			String id = UUID.randomUUID().toString().replace("-", "");
			map2.put("id", id);
			//获取用户账号或学号
			String info_id = (String) req.getSession().getAttribute("info_id");
			map2.put("stu_id", info_id);
			map2.put("name", req.getParameter("name"));
			//fs等于1为生源地助学贷款，2为国家助学贷款
			map2.put("fs", req.getParameter("fs"));
			map2.put("phone", req.getParameter("phone"));
			map2.put("adderss", req.getParameter("adderss"));
			map2.put("ps", req.getParameter("ps"));
			map2.put("card", req.getParameter("card"));
			infoMapper.daikuan(map2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		map.put("flag", "true");
		return map;
	}

	@Override
	public Map<String, Object> seldaikuanInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String stu_id = (String) req.getSession().getAttribute("info_id");
		Map<String, String> info = infoMapper.seldaikuanInfo(stu_id);
		map.put("info", info);
		return map;
	}
}
