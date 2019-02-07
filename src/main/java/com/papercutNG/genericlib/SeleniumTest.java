package com.papercutNG.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest extends BaseTest
{

	
	//Implicit - for complete web page
	public static void waitForPageToLoad()
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	//Explicit Wait
	public static void waitForWebElemnet(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
	}


	public static void waitForAlertPopUp()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	//Enter Text
	public static void enterText(WebElement ele, String inputText)
	{
		ele.sendKeys(inputText);
	}
	
	//Clear Text box
	public static void clearTextbox(WebElement ele)
	{
		ele.clear();
	}
	
	
	
	
}
