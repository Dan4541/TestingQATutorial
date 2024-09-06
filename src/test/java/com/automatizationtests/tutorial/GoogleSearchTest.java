package com.automatizationtests.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

	private WebDriver driver;
	By videoLinkLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("quality-stream Introducción a la Automatización de pruebas de software");
		//searchBox.sendKeys("kraken");
		searchBox.submit();
		
		//Explicit wait
		//WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//ewait.until(ExpectedConditions.titleContains("quality-stream"));
		
		//Fluent wait
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement video = fwait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {				
				return driver.findElement(videoLinkLocator);
			}
		});
		
		//assertEquals("quality-stream Introducción a la Automatización de pruebas de software - Buscar con Google", driver.getTitle());
		//assertEquals("kraken - Buscar con Google", driver.getTitle());
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}
