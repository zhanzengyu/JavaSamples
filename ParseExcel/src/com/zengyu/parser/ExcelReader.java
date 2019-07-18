package com.zengyu.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public List<StudentScore> read(String fileName) throws EncryptedDocumentException, IOException {
		if (fileName == null) return null;
		
		File xlsFile = new File(fileName);
		if (!xlsFile.exists()) return null;
		
		// 工作表
		Workbook workbook = WorkbookFactory.create(xlsFile);
		// 表个数
		int numberOfSheets = workbook.getNumberOfSheets();
//		System.out.println(numberOfSheets);
		if (numberOfSheets <= 0) return null;
		
		List<StudentScore> list = new ArrayList<>();
		//我们的需求只需要处理一个表，因此不需要遍历
		Sheet sheet = workbook.getSheetAt(0);
		// 行数
		int rowNumbers = sheet.getLastRowNum() + 1;
//		System.out.println(rowNumbers);
		StudentScore score;
		// 读数据，第二行开始读取
		for (int row = 1; row < rowNumbers; row++) {
			Row r = sheet.getRow(row);
//			System.out.println(r.getPhysicalNumberOfCells());
			//我们只需要前两列
			if (r.getPhysicalNumberOfCells() >= 2) {
				score = new StudentScore(r.getCell(0).toString(), (int) Double.parseDouble(r.getCell(1).toString()));
				list.add(score);
			} 
		}
		return list;
	}
}
