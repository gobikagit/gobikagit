package com.myTestPages;

import org.testng.annotations.Test;

import com.myPages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginGmailTest extends LoginPage {
	

public LoginGmailTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

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
           dologin("xyzseleniumtest@gmail.com", "passwordtest@01");
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
			dologin("xyzseleniumtest@gmail.com", "passwordtest@01");
 			Logincheck();
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
			dologin("xyzseleniumtest@gmail.com", "password@01");
			ErrorMsgcheck();	
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
