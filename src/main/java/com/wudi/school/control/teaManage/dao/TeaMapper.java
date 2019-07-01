package com.wudi.school.control.teaManage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TeaMapper {

	List<Map<String,String>> getStuInfo();

	Map<String,String> selStuInfoById(String id);

	void report(String id);

	List<Map<String, String>> selStuStatus();

	void jiaona(String id);

	int updatePwd(HashMap<String, String> hashMap);

	void updatedaikuanInfo(String stu_id);

}
