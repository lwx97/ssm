package com.wudi.school.control.noticeManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.noticeManage.dao.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	@Override
	public Map<String, Object> getNoticeList() {
		HashMap<String, Object> map = new HashMap<>();
		List<Map<String, String>> list = noticeMapper.getNoticeList();
		map.put("noticeList", list);
		return map;
	}

}
