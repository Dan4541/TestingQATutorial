package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{

	//Signing In Process Locators
	By usernameLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By loginBtnLocator = By.name("submit");
	By flightsBtnLocator = By.linkText("Flights");
	By loginSuccessPageLocator = By.xpath("//h3[text()='Login Successfully']");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void signIn() {
		
		if(isDisplayed(usernameLoginLocator)) {
			type("newdan049@gmail.com", usernameLoginLocator);
			type("Kdlxqr.0", passwordLoginLocator);
			click(loginBtnLocator);
		}else {
			System.out.println("User name textbox was not displayed.");
		}
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(loginSuccessPageLocator);
	}

	
}
