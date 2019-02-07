package com.papercutNG.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.papercutNG.genericlib.BaseTest;
import com.papercutNG.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	public static LoginPage login;
	
	@Test(priority=1,description="Verify Login page with valid data")
	public void Login_Test_TC_01() throws FileNotFoundException, IOException, InterruptedException
	{
		//Creating report
		test = extent.createTest("Verify Login with valid credentials");
		
		
		//Creating object for the Login Class
		login=PageFactory.initElements(driver, LoginPage.class);
		
		//Login to application
		login.loginToApp();
		
		//Logout from the application
		login.logoutFromApp();
		
	}
	
	
	
}
