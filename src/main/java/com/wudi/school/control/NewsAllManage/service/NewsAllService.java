package com.wudi.school.control.NewsAllManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface NewsAllService {

	Map<String,Object> getNewsList();

	Map<String,Object> getNewsById(HttpServletRequest req);

	Map<String,Object> getNewsListByTypeId(HttpServletRequest req);

	Map<String,Object> getNewsFlashList();

	Map<String,Object> getNewsFlashListByTypeId(HttpServletRequest req);

	Map<String,Object> getNewsFlashById(HttpServletRequest req);

}
