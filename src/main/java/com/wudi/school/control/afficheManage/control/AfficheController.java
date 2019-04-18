package com.wudi.school.control.afficheManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.afficheManage.service.AfficheService;

@Controller
@RequestMapping("affiche")
public class AfficheController extends BaseController{

	@Resource
	private AfficheService afficheService;
	
	@RequestMapping("getAfficheList")
	public void getAfficheList(HttpServletResponse res){
		writeUTFJson(res, afficheService.getAfficheList());
	}
	
}
