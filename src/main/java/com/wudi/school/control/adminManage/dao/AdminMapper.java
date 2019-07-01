package com.wudi.school.control.adminManage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminMapper {

	List<Map<String,String>> getInfo();

	
	String getUser(String id );

	void updatePower(HashMap<String, String> hashMap);


	List<Map<String, String>> getMenuType();


	List<Map<String, String>> getMenu(String id);


	void saveInfo(HashMap<String, String> map1);
}
