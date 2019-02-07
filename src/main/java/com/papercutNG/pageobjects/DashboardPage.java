package com.papercutNG.pageobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	
	//Build Number
	@FindBy(how=How.XPATH ,using="//span[contains(text(),'(Build')]")
	private WebElement buildNumber;
	
	public WebElement getBuildNumberFromDashboard()
	{
		return buildNumber;
	}
	

	//Version Number
	@FindBy(how=How.XPATH ,using="//div[@class='product-details']/span[2]")
	private WebElement versionNumber;
	
	public WebElement getVersionNumberfromDashboard()
	{
		return versionNumber;
	}
	
	
	//Extract Build Number from String
	public String getBuildNumber(String string)
	{
		String a = null;
		Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(string);
        while(m.find()) {
           a =m.group();
        	          
        }
        return a ;
	}
	
	
}
