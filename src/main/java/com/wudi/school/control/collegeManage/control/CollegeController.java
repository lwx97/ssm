package com.wudi.school.control.collegeManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.collegeManage.service.CollegeService;


@Controller
@RequestMapping("college")
public class CollegeController extends BaseController{
	
	@Resource
	CollegeService collegeService;
	
	@RequestMapping("getCollegeList")
	public void getCollegeList(HttpServletResponse res){
		writeUTFJson(res, collegeService.getCollegeList());
	}
	
	@RequestMapping("getCollegeById")
	public void getCollegeById(HttpServletResponse res, HttpServletRequest request){
		writeUTFJson(res, collegeService.getCollegeById(request));
	}
	
	@RequestMapping("getTuitionList")
	public void getTuitionList(HttpServletResponse res, HttpServletRequest request){
		writeUTFJson(res, collegeService.getTuitionList(request));
	}
}
