package com.papercutNG.dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.papercutNG.genericlib.BaseTest;
import com.papercutNG.pageobjects.AboutPage;
import com.papercutNG.pageobjects.DashboardPage;
import com.papercutNG.pageobjects.LoginPage;

public class DashboardTest extends BaseTest {

	public static LoginPage login;
	public static DashboardPage dashboard;
	public static AboutPage aboutpage;
	
	
	@Test(priority=1,description="Verify Build Numaber in Dashboard Page with About Page")
	public void Dashboard_TC_03() throws FileNotFoundException, IOException, InterruptedException
	{
		//Creating report
		test = extent.createTest("Print Build Number and Version Number in Dashboard page");
		
		
		//Creating object for the Login Class
		login=PageFactory.initElements(driver, LoginPage.class);
		dashboard=PageFactory.initElements(driver, DashboardPage.class);
		
		//Login to Application
		login.loginToApp();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Print Build Number
		test.log(Status.PASS, "Build Number in Dashboard Page is : "+dashboard.getBuildNumber(dashboard.getBuildNumberFromDashboard().getText()));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.log(Status.PASS, "Version Number in Dashboard Page is : "+dashboard.getVersionNumberfromDashboard().getText());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Logout
		login.logoutFromApp();
	}
	
	@Test(priority=1,description="Verify Version Numaber from Dashboard Page with About Page")
	public void Dashboard_TC_04() throws FileNotFoundException, IOException, InterruptedException
	{
		//Creating report
		test = extent.createTest("Validate Build & Version Number in Dashboard with About Page");
		
		
		//Creating object for the Login Class
		login=PageFactory.initElements(driver, LoginPage.class);
		dashboard=PageFactory.initElements(driver, DashboardPage.class);
		aboutpage=PageFactory.initElements(driver, AboutPage.class);
		
		//Login to Application
		login.loginToApp();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		aboutpage.getAboutTab().click();
		
		//Validate Build Number in Dash board with About Page
		String buildAndVersionNumber=aboutpage.getBuildAndVersionNumberFromAboutPage().getText();
		test.log(Status.PASS,"Build and Version number is : "+buildAndVersionNumber);
		
		//get Build number in Dash board Page
		String Dashboard_Page_BuildNumber=dashboard.getBuildNumber(dashboard.getBuildNumberFromDashboard().getText());
		test.log(Status.PASS, "Build Number from Dashboard page is : "+Dashboard_Page_BuildNumber);
		
		//get Build Number From About Page
		String About_Page_buildNumber=dashboard.getBuildNumber(buildAndVersionNumber);
		test.log(Status.PASS, "Build Number from About page is : "+About_Page_buildNumber);
		
		//Validate Build Number from both Dashboard and About Pages
		Assert.assertEquals(Dashboard_Page_BuildNumber, About_Page_buildNumber);
		test.log(Status.PASS,"Build Number is same in Both Dashboard and About page is same");
		
		//Logout
		login.logoutFromApp();
	}
}
