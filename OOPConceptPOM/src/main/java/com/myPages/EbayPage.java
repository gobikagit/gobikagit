package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EbayPage {
   static WebDriver driver;
   
   By searchtext = By.xpath("//input[@type='text']");
   By searchoption = By.xpath("//input[@type='submit']");
   static By FirstItemPrice = By.xpath("/html/body/div[4]/div[5]/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[3]/div[1]/span");
   

	public EbayPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void SearchItem(String inp)
	{
		driver.findElement(searchtext).sendKeys(inp);
	}
	public void ClickSearch()
	{
		driver.findElement(searchoption).click();
	}
	
	public static String FirstPrlicelist()
	{
		return driver.findElement(FirstItemPrice).getText();
		
	}
   
   
}
