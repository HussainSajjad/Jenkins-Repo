package com.cicd.jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	WebDriver driver;	
	
	@BeforeMethod
	public void launchDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void testOne() {
		WebElement ele = driver.findElement(By.name("btnK"));
		Assert.assertTrue(ele.getAttribute("value").equalsIgnoreCase("Googl Search"));
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
	
	
}
