package com.wudi.school.control.teaManage.control;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.teaManage.service.TeaService;

@RequestMapping("tea")
@Controller
public class TeaController extends BaseController {
	@Resource
	private TeaService teaService;
	
	@RequestMapping("getStuInfo")
	public void getStuInfo(HttpServletResponse res) {
		writeUTFJson(res, teaService.getStuInfo());
	}
	@RequestMapping("report")
	public void report(HttpServletResponse res,HttpServletRequest req) {
		writeUTFJson(res, teaService.report(req));
	}
	@RequestMapping("selStuInfoById")
	public void selStuInfoById(HttpServletResponse res,HttpServletRequest req) {
		writeUTFJson(res, teaService.selStuInfoById(req));
	}
	@RequestMapping("getInfo")
	public void getInfo(HttpServletResponse res) {
		writeUTFJson(res, teaService.getInfo());
	}
	@RequestMapping("exporExcel")
	public void exporExcel(HttpServletResponse res) throws IOException {
        HSSFWorkbook wb = teaService.exporExcel();  
        res.setContentType("application/vnd.ms-excel");  
        res.setHeader("Content-disposition", "attachment;filename=student.xls");  
        OutputStream ouputStream = res.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  
	}
	@RequestMapping("jiaona")
	public void jiaona(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, teaService.jiaona(req));
	}
	@RequestMapping("updatePwd")
	public void updatePwd(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, teaService.updatePwd(req));
	}
	@RequestMapping("seldaikuanInfo")
	public void seldaikuanInfo(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, teaService.seldaikuanInfo(req));
	}
	@RequestMapping("updatedaikuanInfo")
	public void updatedaikuanInfo(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, teaService.updatedaikuanInfo(req));
	}
}
