package com.automatizationtests.tutorial;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	
	//Register Process Locators
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");	
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name=confirmPassword]");	
	By registerBtnLocator = By.name("submit");
	
	
	//Signing In Process Locators
	By usernameLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By loginBtnLocator = By.name("submit");
	By flightsBtnLocator = By.linkText("Flights");
	By reservationPageLocator = By.xpath("//img[@src='images/mast_flightfinder.gif']");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
		
		//driver.quit();
	}

	@Test
	public void registerUser() {		
		
		try {
			
			driver.findElement(registerLinkLocator).click();
			
			Thread.sleep(2000);
			
			if(driver.findElement(registerPageLocator).isDisplayed()) {
				
				driver.findElement(userNameLocator).sendKeys("newdan049@gmail.com");
				driver.findElement(passwordLocator).sendKeys("Kdlxqr.0");
				driver.findElement(confirmPasswordLocator).sendKeys("Kdlxqr.0");
				
				driver.findElement(registerBtnLocator).click();
			}
			else {
				System.out.println("The Register page is not Found");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is newdan049@gmail.com.", fonts.get(5).getText());
		
	}
	
	@Test
	public void signIn() {
		
		
		try {
			
			if(driver.findElement(usernameLoginLocator).isDisplayed()) {
				driver.findElement(usernameLoginLocator).sendKeys("newdan049@gmail.com");
				driver.findElement(passwordLoginLocator).sendKeys("Kdlxqr.0");
				driver.findElement(loginBtnLocator).click();
				Thread.sleep(2000);
			}
			
			driver.findElement(flightsBtnLocator).click();
			
			boolean result = driver.findElement(reservationPageLocator).isDisplayed();
			
			
			assertTrue(result);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
