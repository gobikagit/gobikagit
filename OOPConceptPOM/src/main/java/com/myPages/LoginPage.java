package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	public WebDriver driver;
	By emailId=By.id("identifierId");
	By NextButton=By.xpath("//*[@id='identifierNext']/div[1]");
	By Password=By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	By Loginbutton=By.xpath("//*[@id='passwordNext']/div[1]");
	static By UserIcon=By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[3]/div[1]/div[2]/div/a/img");
    
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void Username(String uid)
	{
		driver.findElement(emailId).sendKeys(uid);
	}
	public void ClickNext()
	{
		driver.findElement(NextButton).click();
	}
	public void Password(String pass)
	{
		driver.findElement(Password).sendKeys(pass);
	}
	public void ClickLoginButton()
	{
		driver.findElement(Loginbutton).click();
	}
	
	public void dologin(String uid,String pwd)
	{
		Username(uid);
		ClickNext();
		Password(pwd);
		ClickLoginButton();		
	}
	
	public void  ErrorMsgcheck()
	{
		WebElement ErrorMsg=driver.findElement(By.xpath("//div[@jsname='B34EJ']/span"));
		String Er=ErrorMsg.getText();
		System.out.println(ErrorMsg); 
		if(Er.contains("Wrong password")) 
		{  
		System.out.println("Unable to login, Please enter the correct Password"); 
		} 
	}
	
	public void Logincheck()
	{
	boolean existence =((WebElement) UserIcon).isDisplayed();	
	try{	
		if(existence)
			{
			  System.out.println("User Logged in sucessfully");
		  	}
		else 
		    {
			  System.out.println("User is not logged in Properly");
			}
		  } 
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	}
}
