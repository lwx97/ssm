package com.wudi.school.control.teaManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudi.school.control.infoManage.dao.InfoMapper;
import com.wudi.school.control.teaManage.dao.TeaMapper;
import com.wudi.school.control.userManage.dao.UserMapper;
import com.wudi.school.control.userManage.service.UserService;

@Service
public class TeaServiceImpl implements TeaService{

	@Autowired
	private TeaMapper teaMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private InfoMapper infoMapper;
	@Override
	public Map<String, Object> getStuInfo() {
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		List<Map<String, String>> stuInfoList = teaMapper.getStuInfo();
		
		map.put("list", stuInfoList);
		
		return map;
	}


	@Override
	public Map<String, Object> report(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		String id = req.getParameter("id");
		String flag = "true";
		try {
			teaMapper.report(id);
		}catch(Exception e) {
			e.printStackTrace();
			flag = "false";
		}
		map.put("flag", flag);
		
		return map;
	}


	@Override
	public Map<String, Object> selStuInfoById(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		String id = req.getParameter("id");
		Map<String, String> stuInfo = teaMapper.selStuInfoById(id);
		List<Map<String, String>> list = userMapper.getOutlayInfo(stuInfo.get("stu_id"));
		int outlay_no_all = 0;
		for(Map<String,String> m: list){
			outlay_no_all += Integer.valueOf(m.get("outlay_no"));
		}
		if(outlay_no_all!=0) {
			stuInfo.put("outlay", "未缴纳");
		}else {
			stuInfo.put("outlay", "已缴纳");
		}
		map.put("stuInfo", stuInfo);
		return map;
	}


	@Override
	public Map<String, Object> getInfo() {
		HashMap<String, Object> map = new HashMap<String,Object>();
		HashMap<String, Integer> map2 = new HashMap<String,Integer>();
		//查询已报到和未报到数据
		List<Map<String, String>> list = teaMapper.selStuStatus();
		//现场报到
		int at1 = 0;
		//未报到
		int at2 = 0;
		//网上报到
		int at3 = 0;
		int bt1 = 0;//男
		int bt2 = 0;//女
		for(Map m: list) {
			if(m.get("status").equals("0")) {
				at2++;
			}else if(m.get("status").equals("1")) {
				at3++;
			}else {
				at1++;
			}
			if(m.get("sex").equals("男")) {
				bt1++;
			}else {
				bt2++;
			}
			
		}
		map2.put("at1", at1);
		map2.put("at2", at2);
		map2.put("at3", at3);
		map2.put("bt1", bt1);
		map2.put("bt2", bt2);
		map.put("data", map2);
		return map;
	}


	@Override
	public HSSFWorkbook exporExcel() {
		//创建工作簿---->XSSF代表10版的Excel(HSSF是03版的Excel)
		HSSFWorkbook wb = new HSSFWorkbook();
	    //工作表
		HSSFSheet sheet = wb.createSheet("学生列表");
	    //标头行，代表第一行
	    HSSFRow header=sheet.createRow(0);
	    //创建单元格，0代表第一行第一列
	    HSSFCell cell0=header.createCell(0);
	    cell0.setCellValue("学号");
	    header.createCell(1).setCellValue("姓名");
	    header.createCell(2).setCellValue("性别");  
	    header.createCell(3).setCellValue("身份证号");
	    header.createCell(4).setCellValue("班级名称");  
	    header.createCell(5).setCellValue("联系电话");
	    header.createCell(6).setCellValue("报到状态");
	    //获取学生信息
	    List<Map<String, String>> list = teaMapper.getStuInfo();
	    for(int i=0;i<list.size();i++) {
	    	Map<String, String> m = list.get(i);
	    	HSSFRow header1=sheet.createRow(i+1);
		    //创建单元格，0代表第一行第一列
		    HSSFCell cell=header1.createCell(0);
		    cell.setCellValue(m.get("stu_id"));
		    header1.createCell(1).setCellValue(m.get("name"));
		    header1.createCell(2).setCellValue(m.get("sex"));  
		    header1.createCell(3).setCellValue(m.get("card"));
		    header1.createCell(4).setCellValue(m.get("class_name"));  
		    header1.createCell(5).setCellValue(m.get("phone"));
		    if(m.get("status")=="1") {
		    	header1.createCell(6).setCellValue("已网上报到");
		    }else if(m.get("status")=="2"){
		    	header1.createCell(6).setCellValue("已现场报到");
		    }else {
		    	header1.createCell(6).setCellValue("未报到");
		    }
		    header1.setHeightInPoints(25);
	    }
	    
	    //设置列的宽度
	    //getPhysicalNumberOfCells()代表这行有多少包含数据的列
	    for(int i=0;i<header.getPhysicalNumberOfCells();i++){
	     //POI设置列宽度时比较特殊，它的基本单位是1/255个字符大小，
	     //因此我们要想让列能够盛的下20个字符的话，就需要用255*20
	     sheet.setColumnWidth(i, 255*20);
	    }
	    //设置行高，行高的单位就是像素，因此30就是30像素的意思
	    header.setHeightInPoints(30);
	    return wb;  
	}


	@Override
	public Map<String, Object> jiaona(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String id = req.getParameter("id");
			teaMapper.jiaona(id);
		}catch (Exception e) {
			return null;
		}
		map.put("flag", "true");
		return map;
	}


	@Override
	public Map<String, Object> updatePwd(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		int i = 0;
		try {
			String account = (String) req.getSession().getAttribute("account");
			String p1 = req.getParameter("p1");
			String p = req.getParameter("p");
			HashMap<String, String> hashMap = new HashMap<>();
			hashMap.put("p1", p1);
			hashMap.put("p", p);
			hashMap.put("account", account);
			i = teaMapper.updatePwd(hashMap);
		}catch (Exception e) {
			return null;
		}
		if(i==0) {
			map.put("flag", "flase");
		}else {
			map.put("flag", "true");
		}
		
		return map;
	}


	@Override
	public Map<String, Object> seldaikuanInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		String stu_id = req.getParameter("id");
		Map<String, String> info = infoMapper.seldaikuanInfo(stu_id);
		map.put("info", info);
		return map;
	}


	@Override
	public Map<String, Object> updatedaikuanInfo(HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String stu_id = req.getParameter("id");
			teaMapper.updatedaikuanInfo(stu_id);
		}catch (Exception e) {
			return null;
		}
		map.put("flag", "true");
		return map;
	}


}
