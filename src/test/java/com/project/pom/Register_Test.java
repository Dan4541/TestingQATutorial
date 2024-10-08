package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Register_Test {

	private WebDriver driver;
	RegisterPage registerPage;
	
	@Before
	public void setUp() throws Exception {
		
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("http://demo.guru99.com/test/newtours/index.php");
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		registerPage.registerUser();
		assertEquals("Note: Your user name is newdan049@gmail.com.", registerPage.registeredMessage());
	}

}
