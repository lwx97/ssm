package com.wudi.school.control.mainViewManage.dao;

import java.util.List;
import java.util.Map;

public interface MainViewMapper {
	/**
	 * 查询校长致辞
	 * @return
	 */
	String getXZZC();
	/**
	 * 查询院系列表,6个
	 * @return
	 */
	List<Map<String, String>> getCollegeName();
	/**
	 * 查询新闻快讯,最新的6个
	 * @return
	 */
	List<Map<String, String>> getNewsFlash();

	/**
	 * 查询要闻，最新6个
	 * @return
	 */
	List<Map<String, String>> getNews();
	/**
	 * 查询校园视频3
	 * @return
	 */
	List<Map<String, String>> getVideo();
	/**
	 * 查找图片4
	 * @return
	 */
	List<Map<String, String>> getImgs4();
	
}
