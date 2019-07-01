package com.wudi.school.control.adminManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.adminManage.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController{
	
	@Resource
	private AdminService adminService;
	
	@RequestMapping("getInfo")
	public void getInfo(HttpServletResponse res) {
		writeUTFJson(res, adminService.getInfo());
	}
	@RequestMapping("updatePower")
	public void updatePower(HttpServletResponse res,HttpServletRequest req) {
		writeUTFJson(res, adminService.updatePower(req));
	}
	@RequestMapping("getMenuType")
	public void getMenuType(HttpServletResponse res) {
		writeUTFJson(res, adminService.getMenuType());
	}
	@RequestMapping("getMenu")
	public void getMenu(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, adminService.getMenu(req));
	}
	@RequestMapping("saveInfo")
	public void saveInfo(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, adminService.saveInfo(req));
	}
}
