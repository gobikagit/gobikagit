package com.myTestPages;

import org.testng.annotations.Test;

import com.myPages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoginGmailTest{
	WebDriver driver;
	
@BeforeMethod
  public void setup() 
  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();  
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("https://www.gmail.com/");
  }
  
  @Test(priority=1,description="Valid Login and Password")
  public void Validlogin()
	{
		try {

			LoginPage obj=new LoginPage(driver);
			obj.dologin("xyzseleniumtest@gmail.com", "passwordtest@01");
			}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
	}
 
  @Test(priority=2)
  public void UserProfilecheck()
 	{
 		try {
 			LoginPage obj=new LoginPage(driver);
			obj.dologin("xyzseleniumtest@gmail.com", "passwordtest@01");
 			obj.Logincheck();
 			}
 		catch(Exception e)
 		{
 		  System.out.println(e.getMessage());
 		}
 	}
  
  @Test(priority=3,description="Valid and invalid Password")
  public void InValidlogin()
	{
		try {
			LoginPage obj=new LoginPage(driver);
			obj.dologin("xyzseleniumtest@gmail.com", "password@01");
			obj.ErrorMsgcheck();	
			}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
	}
  
  @AfterMethod
  public void teardown()
  {
	  driver.quit();
  }
  
}
