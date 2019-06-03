package com.wudi.school.control.bookManage.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudi.school.common.base.controller.BaseController;
import com.wudi.school.control.bookManage.service.BookService;

@Controller
@RequestMapping("book")
public class BookController extends BaseController{

	@Resource
	private BookService bookService;
	
	@RequestMapping("getBookByTuId")
	public void getBookByTuId(HttpServletResponse res,HttpServletRequest req) {
		writeUTFJson(res, bookService.getBookByTuId(req));
	}
}
