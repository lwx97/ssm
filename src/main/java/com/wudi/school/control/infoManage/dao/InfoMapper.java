package com.wudi.school.control.infoManage.dao;

import java.util.Map;

public interface InfoMapper {

	public int sendReportInfo(Map<String, String> map2);

	public void updateInfo(String id);

	public void daikuan(Map<String, String> map2);

	public Map<String,String> seldaikuanInfo(String stu_id);

}
