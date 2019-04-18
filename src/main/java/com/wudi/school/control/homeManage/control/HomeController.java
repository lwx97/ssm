package com.wudi.school.control.homeManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.homeManage.service.HomeService;

@Controller
@RequestMapping("home")
public class HomeController extends BaseController{

	@Resource
	private HomeService homeService;
	
	@RequestMapping("getHomeSchoolList")
	public void getHomeSchoolList(HttpServletResponse res){
		writeUTFJson(res, homeService.getHomeSchoolList());
	}
}
