package com.TestRunner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Junittest {
	
	WebDriver  driver;
	
	@BeforeClass
	public  void beforemethod()
	
		{
			System.setProperty("webdriver.chrome.driver","./BrowserUtils/chromedriver.exe");	
			driver = new ChromeDriver();
			driver.get("https://www.swiggy.com/");
			System.out.println("before method");
		}
	
	
	@Test
	public  void testmethod()
	{
		System.out.println("before method");
	}

}
