package com.wudi.school.control.adminManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {

	Map<String,Object> getInfo();

	Map<String,Object> updatePower(HttpServletRequest req);

	Map<String,Object> getMenuType();

	Map<String,Object> getMenu(HttpServletRequest req);

	Map<String,Object> saveInfo(HttpServletRequest req);

}
