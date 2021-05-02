package com.accenttech.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;
	public static void openExcel(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
			book= new XSSFWorkbook(fis);//will work for the xlsx format
		//	book= new HSSFWorkbook(fis); //will work for the xls format
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetName) {
		sheet=book.getSheet(sheetName);
		
	}
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
public static int columnCount(int rownum) {
		return sheet.getRow(rownum).getLastCellNum();
	}

public static String getData(int rowindex,int columnindex) {
	return sheet.getRow(rowindex).getCell(columnindex).toString();
}


//two dimensional array in java

public static Object[][] excelData(String filePath,String sheetName){
	openExcel(filePath);
	loadSheet(sheetName);
int totalRows=rowCount();
int totalColumns=columnCount(0);
Object[][] testData= new Object[totalRows-1][totalColumns];

//iterating rows
for(int i=1;i<totalRows;i++) {
	//iterating the columns
	for(int j=0;j<totalColumns;j++) {
		testData[i-1][j]=	getData(i,j);
	}
}
return testData;

}


}
