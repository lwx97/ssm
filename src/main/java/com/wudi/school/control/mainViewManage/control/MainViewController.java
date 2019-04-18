package com.wudi.school.control.mainViewManage.control;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.mainViewManage.service.MainViewService;



@Controller
@RequestMapping("mainView")
public class MainViewController extends BaseController{
	
	@Resource
	MainViewService mainViewService;
	
	@RequestMapping("index")
	public void index(HttpServletResponse resp,HttpServletRequest req) throws IOException{
		writeUTFJson(resp, mainViewService.index(req));
	}
}
