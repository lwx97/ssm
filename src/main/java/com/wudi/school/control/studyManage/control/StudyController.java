package com.wudi.school.control.studyManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.studyManage.service.StudyService;

@Controller
@RequestMapping("study")
public class StudyController extends BaseController{

	@Resource
	private StudyService studyService;
	
	@RequestMapping("getStudySchoolList")
	public void getStudySchoolList(HttpServletResponse res){
		writeUTFJson(res, studyService.getStudySchoolList());
	}
}
