package com.wudi.school.common.constant;
/**
 * 全局常量类
 * @author liwenxiang
 *
 */
public class GlobalConstant {
	
	
	/**
	 * 系统主页路径
	 */
	public static final String INDEX_PATH = "/index.html";
	/**
	 * 学生权限带有特定字符的URL
	 */
	public static final String STU_URL = "student";
	/**
	 * 教师权限带有特定字符的URL
	 */
	public static final String TEA_URL = "teacher";
	/**
	 * 超管权限带有特定字符的URL
	 */
	public static final String ADMIN_URL = "admin";
	
	/**
	 * 访客的角色数值
	 */
	public static final String VIS_VALUE = "0";
	/**
	 * 学生的角色数值
	 */
	public static final String STU_VALUE = "1";
	/**
	 * 教师的角色数值
	 */
	public static final String TEA_VALUE = "2";
	/**
	 * 超管的角色数值
	 */
	public static final String ADMIN_VALUE = "3";

	/**
	 * 当tu_id=0时，为公共课。当tu_id= "-1"时，为选修。选修暂且不写。
	 */
	public static final String COURSE_TU_ID = "0";
}
