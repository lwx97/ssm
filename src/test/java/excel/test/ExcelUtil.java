package excel.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;




public class ExcelUtil {

	
	public static void importExcel() throws IOException{
		FileInputStream in = new FileInputStream("D:\\ultrapower\\workbook.xls");
		HSSFWorkbook wb = new HSSFWorkbook(in);
		HSSFSheet sheet0 = wb.getSheetAt(0);
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for(Row r : sheet0){
			if(r.getRowNum()<2)
				continue;
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("name", r.getCell(0).getStringCellValue());
			map.put("class", r.getCell(1).getStringCellValue());
			map.put("score", r.getCell(2).getStringCellValue());
			list.add(map);
		}
		in.close();
		System.out.println(list.toString());
		
	}
	
	public static void exportExcel() throws IOException{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("成绩单");
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell = row1.createCell(0);
		cell.setCellValue("学员考试成绩一览表");
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
		HSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("成绩");
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("小米");
		row3.createCell(1).setCellValue("高二一班");
		row3.createCell(2).setCellValue("90");
		
		//输出Excel文件
		
		FileOutputStream out = new FileOutputStream("D:\\ultrapower\\workbook.xls");
		wb.write(out);
		out.flush();
	}

	
	public static void main(String[] args) throws IOException {
		importExcel();
	}
}
