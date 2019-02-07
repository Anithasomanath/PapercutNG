package com.papercutNG.genericlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataParser
{
	
	public static void writeToExcel(String input,  int colNum) throws Exception
	{
		
		FileInputStream fIPS= new FileInputStream(System.getProperty("user.dir")+"\\Results\\Results.xlsx"); 
		XSSFWorkbook workbook = new XSSFWorkbook(fIPS);
		XSSFSheet sheet = workbook.getSheet("Test");
		
		//Create a new row in current sheet
		int lastRow=sheet.getLastRowNum();
		
		System.out.println("last row num is : "+lastRow);
		Row row = sheet.createRow(lastRow+1);
		
		//Create a new cell in current row
		Cell cell = row.createCell(colNum);
		
		//Set value to new value
		cell.setCellValue(input);

		//finally write data to excel file
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\Results\\Results.xlsx"));
		workbook.write(out);
		out.close();
	}

}
