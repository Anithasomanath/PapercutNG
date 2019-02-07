package com.papercutNG.dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.papercutNG.genericlib.BaseTest;
import com.papercutNG.pageobjects.LoginPage;
import com.papercutNG.pageobjects.MenuPage;

public class MenuTest extends BaseTest  {

	public static LoginPage login;
	public static MenuPage menuPage;
	
	
	@Test(priority=1,description="Verify Number of links in Home Page")
	public void Menu_Links_TC_02() throws FileNotFoundException, IOException, InterruptedException
	{
		//Creating report
		test = extent.createTest("Validate All Menu Links");
		
		
		//Creating object for the Login Class
		login=PageFactory.initElements(driver, LoginPage.class);
		menuPage=PageFactory.initElements(driver, MenuPage.class);
		
		//Login to the Application
		login.loginToApp();
		
		//Verify Menu Links
		List<WebElement>  links=menuPage.getTotalMenuLinks();
		
		//Validate Total links
		Assert.assertEquals(links.size(), 11);
		test.log(Status.PASS,"Total Links are: "+links.size());
		
		//Print Links
		for(int i=0; i<links.size();i++)
		{
			menuPage.verifyLink(links.get(i).getAttribute("href"));
			
			
		}
		
		//Logout
		login.logoutFromApp();
		
	}
	
	
	
	


}
