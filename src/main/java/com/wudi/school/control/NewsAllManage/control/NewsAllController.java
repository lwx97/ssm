package com.wudi.school.control.NewsAllManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.NewsAllManage.service.NewsAllService;

@Controller
@RequestMapping("newsAll")
public class NewsAllController extends BaseController{
	
	@Resource
	NewsAllService newsAllService;
	
	@RequestMapping("getNewsList")
	public void getNewsList(HttpServletResponse res){
		writeUTFJson(res, newsAllService.getNewsList());
	}
	@RequestMapping("getNewsById")
	public void getNewsById(HttpServletResponse res,HttpServletRequest req){
		writeUTFJson(res, newsAllService.getNewsById(req));
	}
	@RequestMapping("getNewsListByTypeId")
	public void getNewsListByTypeId(HttpServletResponse res,HttpServletRequest req){
		writeUTFJson(res, newsAllService.getNewsListByTypeId(req));
	}
	@RequestMapping("getNewsFlashList")
	public void getNewsFlashList(HttpServletResponse res) {
		writeUTFJson(res, newsAllService.getNewsFlashList());
	}
	@RequestMapping("getNewsFlashListByTypeId")
	public void getNewsFlashListByTypeId(HttpServletResponse res,HttpServletRequest req){
		writeUTFJson(res, newsAllService.getNewsFlashListByTypeId(req));
	}
	@RequestMapping("getNewsFlashById")
	public void getNewsFlashById(HttpServletResponse res,HttpServletRequest req){
		writeUTFJson(res, newsAllService.getNewsFlashById(req));
	}
}
