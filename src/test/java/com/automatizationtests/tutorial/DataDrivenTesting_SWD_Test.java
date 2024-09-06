package com.automatizationtests.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_SWD_Test {

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://automationpractice.com");
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {

		String filePath = "C:\\Users\\Danny\\OneDrive\\Documents\\APRENDER\\Clothes_Automation_Excels.xlsx";
		
		String searchText = readFile.getCellValue(filePath, "Sheet1", 0, 0);
		
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();
		
		System.out.println("Page result text: "+resultText);
		
		readFile.readExcel(filePath, "Sheet1");
		writeFile.writeCellValue(filePath, "Sheet1", 0, 1, resultText);
		readFile.readExcel(filePath, "Sheet1");
		
	}

}
