package com.zengyu.parser;

import java.util.Collections;
import java.util.List;

public class ParserStart {

	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir");
//		System.out.println(path);
		String resourceDirPath = path + "/ParseExcel/resource/";
		String inputFileName = resourceDirPath + "input.xls";
		// 第一步：读取数据
		List<StudentScore> dataList = new ExcelReader().read(inputFileName);
//		System.out.println(dataList);
		// 第二步：排序
		Collections.sort(dataList);
//		System.out.println(dataList);
		String outputFileName = resourceDirPath + "output.xls";
		// 第三部：写入数据
		new ExcelWriter().write(outputFileName, dataList);
	}

}