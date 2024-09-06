package com.automatizationtests.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {}

	public void readExcel(String filePath, String sheetName) {
		
		try {
			
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
			
			int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
			
			for (int i = 0; i < rowCount; i++) {
				XSSFRow row = newSheet.getRow(i);
				
				for (int j = 0; j < row.getLastCellNum(); j++) {
					System.out.println(row.getCell(j).getStringCellValue()+ "$$");
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) {
		
		String result = "";
		try {
			
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
			
			XSSFRow row = newSheet.getRow(rowNumber);
			XSSFCell cell = row.getCell(cellNumber);
			
			result = cell.getStringCellValue();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
