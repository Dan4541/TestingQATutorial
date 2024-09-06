package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{

	//Register Process Locators
		By registerLinkLocator = By.linkText("REGISTER");
		By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");	
		By userNameLocator = By.id("email");
		By passwordLocator = By.name("password");
		By confirmPasswordLocator = By.cssSelector("input[name=confirmPassword]");	
		By registerBtnLocator = By.name("submit");
		By registeredMessage = By.tagName("font");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void registerUser() {
		
		try {
			
			click(registerLinkLocator);
			Thread.sleep(2000);
			
			if(isDisplayed(registerPageLocator)) {
				type("newdan049@gmail.com", userNameLocator);
				type("Kdlxqr.0", passwordLocator);
				type("Kdlxqr.0", confirmPasswordLocator);
				
				click(registerBtnLocator);
			} else {
				System.out.println("The Register page is not Found");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String registeredMessage() {
		
		List<WebElement> fonts = getElements(registeredMessage);
		return getText(fonts.get(5));
	}

}
