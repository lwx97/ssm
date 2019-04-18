package com.wudi.school.control.userManage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

	HashMap<String, String> ulogin(HashMap<String, String> hmap);

	HashMap<String, String> getMyInfo(String account);

	HashMap<String, String> getClassInfo(String info_id);

	List<Map<String, String>> getIndex(String stu_id);

	List<Map<String, String>> getOutlayInfo(String stu_id);

	void outlayObjection(String id, String outlay_ps);

}
