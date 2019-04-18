package com.wudi.school.control.userManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.userManage.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	
	@RequestMapping("ulogin")
	public void ulogin(HttpServletResponse res,HttpServletRequest req){
		writeUTFJson(res, userService.ulogin(req,res));
	}
	
	@RequestMapping("getMyInfo")
	public void getMyInfo(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, userService.getMyInfo(req));
	}
	@RequestMapping("getClassInfo")
	public void getClassInfo(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, userService.getClassInfo(req));
	}
	@RequestMapping("getIndex")
	public void getIndex(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, userService.getIndex(req));
	}
	@RequestMapping("getOutlayInfo")
	public void getOutlayInfo(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, userService.getOutlayInfo(req));
	}
	@RequestMapping("outlayObjection")
	public void outlayObjection(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, userService.outlayObjection(req));
	}
}
