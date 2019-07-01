package com.wudi.school.control.infoManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.infoManage.service.InfoService;

@Controller
@RequestMapping("info")
public class InfoController extends BaseController{

	@Resource
	private InfoService infoService;
	@RequestMapping("sendReportInfo")
	public void sendReportInfo(HttpServletRequest req,HttpServletResponse res){
		writeUTFJson(res, infoService.sendReportInfo(req));
	}
	@RequestMapping("daikuan")
	public void daikuan(HttpServletRequest req,HttpServletResponse res) {
		writeUTFJson(res, infoService.daikuan(req));
	}
	@RequestMapping("seldaikuanInfo")
	public void seldaikuanInfo(HttpServletResponse res,HttpServletRequest req) {
		writeUTFJson(res, infoService.seldaikuanInfo(req));
	}
}
