package com.papercutNG.genericlib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest 
{
	//WebDriver object
	public static WebDriver driver;

	//Extent Reports object declaration
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ConfigReader config =new ConfigReader();
	
	
	@BeforeSuite
	public void beforeTestSuite() throws UnknownHostException
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\TestResults\\PapercutNG_Test_Automation_Results.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		extent.setSystemInfo("Environment Name", "UAT");
		extent.setSystemInfo("User Name", "HSAnitha");
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Test Summary Report");
		htmlReporter.config().setReportName("My Customized Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
	
	@AfterSuite
	public void afterTest()
	{
		extent.flush();
	}
	
	
	
	//Launch the browser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException, FileNotFoundException, IOException
	{
		//Launching browser
		openBrowser("Chrome");
	}
	
	
	
	@AfterMethod
	public void validateTestCase(ITestResult result) throws InterruptedException, IOException
	{
		
		//Validate the Test Case status
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Take a screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+result.getMethod().getMethodName()+".png"));
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Customized code
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+result.getMethod().getMethodName()+".png"));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			//Customized code as per our requ.
		}
		else
		{
			System.out.println("Test Case status is not validated");
		}
		
				
		
		//Extent Report Generation -For Each Test Case
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Case FAILED due to below issues: ", ExtentColor.RED));
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED : ",ExtentColor.GREEN));
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED :",ExtentColor.ORANGE));
		
			test.skip(result.getThrowable());
		}
		
		
		//Customized code to validate each and every test case
		Thread.sleep(5000);
		driver.close();
		
		
	}
	
	
	//Open Browser
	public void openBrowser(String browserName) throws InterruptedException, FileNotFoundException, IOException
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Lib\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Lib\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Lib\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Lib\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
			
		}
		else
		{
			System.out.println("Please enter valid browser name");
		}
		
		
		//Navigate to Application
		driver.get(config.getURL());
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
	}
	
	public static void launchApplication()
	{
		
	}
	
	
}
