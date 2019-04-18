package com.wudi.school.control.userManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

	Map<String,Object> ulogin(HttpServletRequest req, HttpServletResponse res);

	Map<String,Object> getMyInfo(HttpServletRequest req);

	Map<String,Object> getClassInfo(HttpServletRequest req);

	Map<String,Object> getIndex(HttpServletRequest req);

	Map<String,Object> getOutlayInfo(HttpServletRequest req);

	Map<String,Object> outlayObjection(HttpServletRequest req);

}
