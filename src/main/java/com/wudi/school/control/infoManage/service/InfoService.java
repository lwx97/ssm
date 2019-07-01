package com.wudi.school.control.infoManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface InfoService {

	Map<String,Object> sendReportInfo(HttpServletRequest req);

	Map<String,Object> daikuan(HttpServletRequest req);

	Map<String,Object> seldaikuanInfo(HttpServletRequest req);

}
