package com.myTestPages;

import org.testng.annotations.Test;

import com.myPages.EbayPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class EbayTestpage {
	WebDriver driver;
	
@BeforeTest
  public void setup() 
  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();  
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("https://www.ebay.com/");
  }

@Test (priority=1)
	public void EbaySearchItem()
	{
	 EbayPage Ebay=new EbayPage(driver);	
	  Ebay.SearchItem("electric guitar");
	  Ebay.ClickSearch();
	}
@Test(priority=2)
  public void EbayvalidatePrice()
  {
	  String ItemPrice=EbayPage.FirstPrlicelist();
	  System.out.println("First Item Price is:"+ItemPrice);
  }
  
@AfterTest
	public void teardown()
	{
	driver.quit();
	}
}
