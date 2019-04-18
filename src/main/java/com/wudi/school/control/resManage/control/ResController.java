package com.wudi.school.control.resManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.resManage.service.ResService;

@Controller
@RequestMapping("res")
public class ResController extends BaseController{
	@Resource
	private ResService resService;
	
	@RequestMapping("getResList")
	public void getResList(HttpServletResponse res){
		writeUTFJson(res, resService.getResList());
	}
}
