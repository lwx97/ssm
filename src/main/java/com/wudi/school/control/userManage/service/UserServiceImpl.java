package com.wudi.school.control.userManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.common.constant.GlobalConstant;
import com.wudi.school.control.userManage.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> ulogin(HttpServletRequest req,HttpServletResponse res) {
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, String> hmap = new HashMap<>();
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String checked = req.getParameter("checked");
		hmap.put("account", account);
		hmap.put("password", password);
		HashMap<String, String> user = userMapper.ulogin(hmap);
		if(user==null){
			map.put("flag", "false");
			return map;
		}
		if(password.equals(user.get("password"))){
			map.put("flag", "true");
			map.put("role", user.get("role"));
			req.getSession().setAttribute("account", account);
			req.getSession().setAttribute("role", user.get("role"));
			req.getSession().setAttribute("info_id", user.get("info_id"));
			if("true".equals(checked)){
				Cookie cookie = new Cookie("user_pass", account+"-"+password);
				cookie.setMaxAge(3600*24*365);
				cookie.setPath("/");
				res.addCookie(cookie);
			}else{
				//删掉cookie
				Cookie[] cookies = req.getCookies();
				for(Cookie cookie : cookies){
					if("user_pass".equals(cookie.getName())){
						cookie.setMaxAge(0);
						cookie.setPath("/");
						res.addCookie(cookie);
					}
				}
			}
		}else{
			map.put("flag", "false");
		}
		return map;
	}

	@Override
	public Map<String, Object> getMyInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String info_id = (String) req.getSession().getAttribute("info_id");
		HashMap<String, String> user = userMapper.getMyInfo(info_id);
		String status = "";
		switch (user.get("status")) {
		case "0":
			status = "未报名";
			break;
		case "1":
			status = "已报名";
			break;
		case "2":
			status = "请假延迟";
			break;
		default:
			status = "其他";
		}
		user.put("status", status);
		map.put("myInfo", user);
		return map;
	}

	@Override
	public Map<String, Object> getClassInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String info_id = (String) req.getSession().getAttribute("info_id");
		HashMap<String, String> classInfo = userMapper.getClassInfo(info_id);
		map.put("classInfo",classInfo);
		return map;
	}

	@Override
	public Map<String, Object> getIndex(HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<>();
		String role = (String)req.getSession().getAttribute("role");
		String stu_id = (String)req.getSession().getAttribute("info_id");
		if(GlobalConstant.STU_VALUE.equals(role)){
			List<Map<String,String>> list = userMapper.getIndex(stu_id);
			int outlay_need_all = 0;
			int outlay_yes_all = 0;
			int outlay_no_all = 0;
			int outlay_ps_count = 0;
			for(Map<String,String> m: list){
				outlay_need_all += Integer.valueOf(m.get("outlay_need"));
				outlay_yes_all += Integer.valueOf(m.get("outlay_yes"));
				outlay_no_all += Integer.valueOf(m.get("outlay_no"));
				if("0".equals(m.get("outlay_ps")))
					outlay_ps_count ++;
			}
			map.put("outlay_need_all", outlay_need_all);
			map.put("outlay_yes_all", outlay_yes_all);
			map.put("outlay_no_all", outlay_no_all);
			map.put("outlay_ps_count", outlay_ps_count);
			map.put("stu_id", stu_id);
			map.put("role", role);
			if(list!=null){
				map.put("name", list.get(0).get("name"));
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> getOutlayInfo(HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<>();
		String role = (String)req.getSession().getAttribute("role");
		String stu_id = (String)req.getSession().getAttribute("info_id");
		List<Map<String,String>> list = userMapper.getOutlayInfo(stu_id);
		int outlay_need_all = 0;
		int outlay_yes_all = 0;
		int outlay_no_all = 0;
		for(Map<String,String> m: list){
			outlay_need_all += Integer.valueOf(m.get("outlay_need"));
			outlay_yes_all += Integer.valueOf(m.get("outlay_yes"));
			outlay_no_all += Integer.valueOf(m.get("outlay_no"));
		}
		map.put("list", list);
		map.put("outlay_need_all", outlay_need_all);
		map.put("outlay_yes_all", outlay_yes_all);
		map.put("outlay_no_all", outlay_no_all);
		map.put("stu_id", stu_id);
		map.put("role", role);
		if(list!=null){
			map.put("name", list.get(0).get("name"));
		}
		return map;
	}

	@Override
	public Map<String, Object> outlayObjection(HttpServletRequest req) {
		String flag = req.getParameter("flag");
		String id = req.getParameter("id");
		Map<String, Object> map= new HashMap<>();
		try{
			//当ps为 0 说明这笔账单未处理，1代表没有问题，2代表有异议
			String outlay_ps = "0";
			if("true".equals(flag)){
				outlay_ps = "1";
			}else if("false".equals(flag)){
				outlay_ps = "2";
			}
			userMapper.outlayObjection(id,outlay_ps);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@Override
	public Map<String, Object> loginOut(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HttpSession session = req.getSession();
		session.removeAttribute("role");
		session.removeAttribute("account");
		session.removeAttribute("info_id");
		map.put("flag", "true");
		return map;
	}
	
}
