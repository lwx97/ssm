package com.wudi.school.control.teaManage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface TeaService {

	Map<String,Object> getStuInfo();

	Map<String,Object> report(HttpServletRequest req);

	Map<String,Object> selStuInfoById(HttpServletRequest req);

	Map<String,Object> getInfo();

	HSSFWorkbook exporExcel();

	Map<String,Object> jiaona(HttpServletRequest req);

	Map<String,Object> updatePwd(HttpServletRequest req);

	Map<String,Object> seldaikuanInfo(HttpServletRequest req);

	Map<String,Object> updatedaikuanInfo(HttpServletRequest req);

}
