package com.wudi.school.control.bookManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface BookService {

	
	public Map<String,Object> getBookByTuId(HttpServletRequest req);
}
