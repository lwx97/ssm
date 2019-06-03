package com.wudi.school.control.bookManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.bookManage.dao.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper bookMapper;

	@Override
	public HashMap<String, Object> getBookByTuId(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<>();
		String info_id = (String) req.getSession().getAttribute("info_id");
		
		List<Map<String, String>> list = bookMapper.getBookByTuId(info_id);
		map.put("bookList", list);
		return map;
	}

}
