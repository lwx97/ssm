package com.wudi.school.control.NewsAllManage.dao;

import java.util.List;
import java.util.Map;

public interface NewsAllMapper {

	List<Map<String,String>> getNewsList(String typeId);

	Map<String, String> getNewsById(String id);

	List<Map<String, String>> getNewsTypeList(String news_type);

	List<Map<String, String>> getNewsFlashList(String typeid);

	Map<String, String> getNewsFlashById(String id);
}
