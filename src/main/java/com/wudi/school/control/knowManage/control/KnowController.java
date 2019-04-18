package com.wudi.school.control.knowManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.knowManage.service.KnowSerivce;

@Controller
@RequestMapping("know")
public class KnowController extends BaseController{

	@Resource
	private KnowSerivce knowService;
	
	
	@RequestMapping("getKnowSchoolList")
	public void getKnowSchoolList(HttpServletResponse res){
		writeUTFJson(res, knowService.getKnowSchoolList());
	}
}
