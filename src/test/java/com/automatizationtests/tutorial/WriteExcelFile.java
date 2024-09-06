package com.automatizationtests.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {}

	public void writeExcel(String filePath, String sheetName, String[] dataToWrite) {
				
		try {
			
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
			
			int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
			
			XSSFRow row = newSheet.getRow(0);
			XSSFRow newRow = newSheet.createRow(rowCount+1);
			
			for (int i = 0; i < row.getLastCellNum(); i++) {
				
				XSSFCell newCell = newRow.createCell(i);
				newCell.setCellValue(dataToWrite[i]);
			}
			
			inputStream.close();
			
			FileOutputStream outputStream = new FileOutputStream(file);
			newWorkBook.write(outputStream);
			
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String rersultText) {
	
		try {
			
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
			XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
			
			XSSFRow row = newSheet.getRow(rowNumber);
			XSSFCell firstCell = row.getCell(cellNumber-1);
			
			System.out.println("Firt cell value is: "+ firstCell.getStringCellValue());
			
			XSSFCell nextCell = row.createCell(cellNumber);
			nextCell.setCellValue(rersultText);
			
			System.out.println("Next cell value is: "+ nextCell.getStringCellValue());
			
			inputStream.close();
			
			FileOutputStream outputStream = new FileOutputStream(file);
			newWorkBook.write(outputStream);
			
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
