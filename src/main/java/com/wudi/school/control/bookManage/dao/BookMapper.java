package com.wudi.school.control.bookManage.dao;

import java.util.List;
import java.util.Map;

public interface BookMapper {

	
	public List<Map<String,String>> getBookByTuId(String info_id);
}
