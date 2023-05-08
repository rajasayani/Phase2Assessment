package com.StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class setpdef {
	

	static WebDriver  driver;
	WebDriverWait wait;
	
	@BeforeAll
	public static  void Beforemethod()
	{
		//initiating the chrome driver
		System.setProperty("webdriver.chrome.driver","./BrowserUtils/chromedriver.exe");	
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		System.out.println("before method");
	}
	
	@After
	public void AfterEach()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Given("The User launched application")
	public void the_user_launched_application() {
	    // Navigating to the Swiggy online application

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		System.out.println("check");
	    
	}

	@When("The user types locations")
	public void the_user_types_locations() throws InterruptedException {
	    
	    driver.findElement(By.id("location")).click();
	    driver.findElement(By.id("location")).sendKeys("Hyd");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class = \"_1oLDb\"]/button/child::span[text() = \"Hyderabad, Telangana, India\"]")).click();
	    
	}

	@Then("Check if the specific location is showing")
	public void check_if_the_specific_location_is_showing() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("check");
	}
	
	@And("Go to a Specific Restaurant")
	public void go_to_a_specific_restaurant() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement search = driver.findElement(By.xpath("(//span[@class = \"_3yZyp\"]/child::*[@class = \"_1GTCc\"])[4]"));
		search.click();
		WebElement TypeRestaurant = driver.findElement(By.xpath("//input[@class = \"_2FkHZ\"]"));
		TypeRestaurant.click();
		TypeRestaurant.sendKeys("Imperial Multi Cuisine Restaurant");
		List<WebElement> Res = driver.findElements(By.xpath("//div[@class = \"RNzoC\"]"));
		for (WebElement k : Res)
		{
			System.out.println(k.getText());
			if(k.getText().equals("Imperial Multi Cuisine Restaurant"))
			{
				
				k.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text() = \"Imperial Multi Cuisine Restaurant\"]")).click();
	}

	@And("Choose Mutton Biriyani from the Menu")
	public void choose_mutton_biriyani_from_the_menu() {
	    // Write code here that turns the phrase above into concrete actions
//	    List<WebElement> Menu  = driver.findElements(By.xpath("//h3[@class = \"styles_itemNameText__3ZmZZ\"]"));
//	    for (WebElement E : Menu)
//	    {
//	    	if (E.getText().equals("Zafrani Mutton Dum Biryani"))
//	    	{
//	    		E.click();
//	    	}
//	    }
		
//		List<WebElement> Menu  = driver.findElements(By.xpath("//div[@class = \"styles_container__-kShr\"]"));
//		for (WebElement E : Menu)
//		{
//			System.out.println(E.getText());
//		}
//		
        JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("window.scrollBy(0, 200)");  
		WebElement MBiryani = driver.findElement(By.xpath("//h3[@class = \"styles_headerTitle__3B76j\"]/child::span[contains(text(),\"Mutton Biryani\")]"));
		MBiryani.click();
	}

	@And("Checkout Mutton Biriyani Family pack")
	public void checkout_mutton_biriyani_family_pack() {
	    // Write code here that turns the phrase above into concrete actions
	   List<WebElement> MB = driver.findElements(By.xpath("//div[@class =\"styles_item__3_NEA styles_hasImage__3OsYt\"]/child::div/child::div[@class = \"styles_itemName__hLfgz\"]/child::h3"));
	   for (int i =0;i<MB.size();i++)
	   {
		   if (MB.get(i).getText().equals("Imperial Special Mutton Biryani"))
		   {
			   int j = i+1;
			   System.out.println(j);
			   WebElement ele = driver.findElement(By.xpath("(//div[@class =\"styles_item__3_NEA styles_hasImage__3OsYt\"]/child::div/child::div[@class =\"styles_itemAddButton__zJ7-R\"]/child::div/child::div[@class =\"_1RPOp\"])"+"["+j+"]"));
			   JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", ele);
			   break;
		   }
	   }
	}

	/*@And("add coupons")
	public void add_coupons() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

}
