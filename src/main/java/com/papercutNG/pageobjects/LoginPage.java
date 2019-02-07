package com.papercutNG.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.papercutNG.genericlib.ConfigReader;

public class LoginPage {

	public static ConfigReader config =new ConfigReader();
	
	@FindBy(how=How.NAME, using="inputUsername")
	private WebElement username;
	
	public WebElement getUsernameTextbox()
	{
		return username;
	}
	
	
	
	
	//Password Text box
	@FindBy(how=How.NAME, using="inputPassword")
	private WebElement password;
	
	public WebElement getPasswordtxtbox()
	{
		return password;
		
	}
	
	
	//Login Button
	@FindBy(how=How.XPATH ,using="//input[@value='Log in']")
	private WebElement loginbutton;
	
	public WebElement getLoginButton()
	{
		return loginbutton;
	}
	
	//User profile 
	@FindBy(how=How.XPATH, using="//span[@aria-label='User:']")
	private WebElement userprofile;
	
	public WebElement getUserProfile()
	{
		return userprofile;
	}
	
	
	//logout
	@FindBy(how=How.XPATH, using="//a[@href='/app?service=direct/1/Dashboard/$Border.logoutLink']")
	private WebElement logout;
	
	public WebElement getLogout()
	{
		return logout;
	}
	
	
	public void logoutFromApp() throws InterruptedException
	{
		userprofile.click();
		Thread.sleep(1000);
		logout.click();
	}
	
	public void loginToApp() throws FileNotFoundException, IOException
	{
		username.sendKeys(config.getUsername());
		password.sendKeys(config.getPassword());
		loginbutton.click();
		
	}
	
}
