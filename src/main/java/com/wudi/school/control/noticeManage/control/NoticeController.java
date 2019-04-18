package com.wudi.school.control.noticeManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.noticeManage.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController{

	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("getNoticeList")
	public void getStudySchoolList(HttpServletResponse res){
		writeUTFJson(res, noticeService.getNoticeList());
	}
}
