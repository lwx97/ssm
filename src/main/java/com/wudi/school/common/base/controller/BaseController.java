package com.wudi.school.common.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.wudi.school.common.utils.JsonUtils;


public abstract class BaseController {
	/**
	 * 获取用户信息
	 * @param req
	 * @return
	 */
//	public SUser getUser(HttpServletRequest req){
//		SUser user=(SUser)req.getSession(false).getAttribute("userinfo");
//		return user;
//	}
	/**
	 * 获取用户id
	 * @param req
	 * @return
	 */
//	public String getUserId(HttpServletRequest req){
//		SUser user=getUser(req);
//		if (user==null) {
//			return "";
//		}
//		return user.getUser_no();
//	}
	
	/**
	 * 根据传入的obj对象返回JSON数据
	 * @param res
	 * @param obj
	 */
	public void writeUTFJson(HttpServletResponse res, Object obj) {
		PrintWriter writer = null;
		try {
			res.setCharacterEncoding("UTF-8");
			writer = res.getWriter();
			writer.write(JsonUtils.beanToJson(obj));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	/**
	 * 根据传入的string对象返回JSON数据
	 * @param res
	 * @param map
	 */
	public void writeUTFJson2(HttpServletResponse res, String map) {
		PrintWriter writer = null;
		try {
			res.setCharacterEncoding("UTF-8");
			writer = res.getWriter();
			writer.write(map);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	/**
	 * 获取列表异常返回空内容
	 * @param res
	 */
	public Map<String, Object> getListError(HttpServletResponse res){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("rows", "[]");
		map.put("total", 0);
		return map;
	}
	
	/**
	 * 获取处理结果异常
	 * @param res
	 * @param message 异常提示
	 */
	public Map<String, Object> getResultErrorToMessage(HttpServletResponse res,String message){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result", "false");
		map.put("messge", message);
		return map;
	}
	
}
