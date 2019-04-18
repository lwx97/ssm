package com.how2java.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("list")
	public void listCategory(HttpServletResponse resp) throws IOException{
		String str= categoryService.list();
		resp.getWriter().write(str);
	}

}
